package android.example.instaeventsv1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private  EditText loginEmailText, loginPasswordText;
    private  Button loginBtn, Regbtn;

    private  FirebaseAuth mAuth;

    private ProgressBar loginProgress;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        loginBtn =findViewById(R.id.login_button);
        Regbtn = findViewById(R.id.lreg_btn);
        loginEmailText = findViewById(R.id.text_email);
        loginPasswordText = findViewById(R.id.text_password);
        loginProgress = findViewById(R.id.login_progress);

        Regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIintent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(regIintent);
            }
        });


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                String loginEmail = loginEmailText.getText().toString();
                String loginPass = loginPasswordText.getText().toString();

                if(!TextUtils.isEmpty(loginEmail) && !TextUtils.isEmpty(loginPass)){
                    loginProgress.setVisibility(View.VISIBLE);

                    mAuth.signInWithEmailAndPassword(loginEmail,loginPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                sendToMain();
                            }
                            else {
                                String errorMessage = task.getException().getMessage();
                                Toast.makeText(LoginActivity.this,  "Error: " + errorMessage, Toast.LENGTH_SHORT).show();
                                loginProgress.setVisibility(View.INVISIBLE);
                            }
                        }
                    });
                }
                else{
                    loginProgress.setVisibility(View.INVISIBLE);

                }
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser != null){
           sendToMain();
        }
        else{

        }
    }

    //Method for sending user to the main activity
    private void sendToMain() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    public void launchSignupActivity(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
