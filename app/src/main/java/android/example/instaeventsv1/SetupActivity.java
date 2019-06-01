package android.example.instaeventsv1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.yalantis.ucrop.UCrop;

import java.io.File;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;


public class SetupActivity extends AppCompatActivity {

    private CircleImageView setupImage;

    //Crop image library implementation
    private final int CODE_IMG_GALLERY = 1;
    private final String SAPLE_CROPPED_IMG_NAME = "SampleCropImg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        setupImage = findViewById(R.id.setup_image);

        Toolbar setupToolbar =  findViewById(R.id.setupToolbar);
        setSupportActionBar(setupToolbar);
        getSupportActionBar().setTitle("Account Settings");

        setupImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //If user device is higher >= marshmallow then permission will be asked for
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    //If the permission is granted
                    if(ContextCompat.checkSelfPermission(SetupActivity.this, READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){

                        Toast.makeText(SetupActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                        ActivityCompat.requestPermissions(SetupActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);


                    }else{

                        startActivityForResult(new Intent().setAction(Intent.ACTION_GET_CONTENT).setType("image/*"),CODE_IMG_GALLERY);

                    }
                }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CODE_IMG_GALLERY && resultCode == RESULT_OK){

            //TODO...

        }else if(requestCode == UCrop.REQUEST_CROP && resultCode == RESULT_OK){

            //TODO...

        }
    }

    private void startCrop(@NonNull Uri uri){
        String destinationFileName = SAMPLE_CROPPED_IMG_NAME;
        destinationFileName += ".jpg";

        UCrop uCrop = UCrop.of(uri,Uri.fromFile(new File(getCacheDir(), destinationFileName)));
    }
}
