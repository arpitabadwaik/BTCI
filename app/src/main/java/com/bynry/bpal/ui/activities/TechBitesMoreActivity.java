package com.bynry.bpal.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bynry.bpal.R;

public class TechBitesMoreActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txtHeadingText, txtDateOfPost, txtDescriptionText, txtLike, txtComment, txtSavePost;
    private ImageView imgLike, imgComment, imgSave, imgSendMessage;
    private EditText edtWriteSomething;
    private ImageView image1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_bites_more);

        txtHeadingText = findViewById(R.id.txt_heading_text);
        txtDateOfPost = findViewById(R.id.txt_date_of_post);
        txtDescriptionText = findViewById(R.id.txt_description_text);
        txtLike = findViewById(R.id.txt_like);
        txtComment = findViewById(R.id.txt_comments);
        txtSavePost = findViewById(R.id.txt_save_post);

        imgLike = findViewById(R.id.img_like);
        imgComment = findViewById(R.id.img_comment);
        imgSave = findViewById(R.id.img_save);
        imgSendMessage = findViewById(R.id.img_message_send_tech_bites);

        edtWriteSomething = findViewById(R.id.edt_write_something_text);

        image1 = findViewById(R.id.image_view);
        image1.setScaleType(ImageView.ScaleType.FIT_XY);

        imgSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == imgSave){
            //Creating the LayoutInflater instance
            LayoutInflater li = getLayoutInflater();
            //Getting the View object as defined in the customtoast.xml file
            View layout = li.inflate(R.layout.customized_toast,(ViewGroup) findViewById(R.id.customized_toast_layout));

            //Creating the Toast object
            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setView(layout);//setting the view of custom toast layout
            toast.show();
        }
    }
}
