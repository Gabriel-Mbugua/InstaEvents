package android.example.instaeventsv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Event_Activity extends AppCompatActivity {

    private TextView tvtitle, tvdescription, tvcategory;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_);

        tvtitle = findViewById(R.id.txtTitle);
        tvdescription = findViewById(R.id.txtDescription);
        tvcategory = findViewById(R.id.txtCategory);
        img = findViewById(R.id.event_thumbnail);

        //Receive data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Category = intent.getExtras().getString("Category");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail");

        //Setting values
        tvtitle.setText(Title);
        tvcategory.setText(Category);
        tvdescription.setText(Description);
        img.setImageResource(image);
    }
}
