package com.bynry.bpal.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bynry.bpal.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class DiscussionActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout layoutHeader, layoutFooter, layoutDetails;
    private RecyclerView recyclerView;
    private CircleImageView circleImgProfilePictureUser;
    private TextView txtWhatsUp, txtCaption;
    private CardView cardWriteMessage;
    private ImageView imgAttach, imgMessageSend, imgBackArrow;
    private EditText edtWriteSomething;
    private String caption;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion);

        layoutHeader = findViewById(R.id.layout_header);
        layoutFooter = findViewById(R.id.layout_footer);
        layoutDetails = findViewById(R.id.layout_details);

        circleImgProfilePictureUser = findViewById(R.id.circle_img_profile_picture_user);

        txtWhatsUp = findViewById(R.id.txt_whats_up);
        txtCaption = findViewById(R.id.txt_caption);

        cardWriteMessage = findViewById(R.id.card_write_message);

        imgAttach = findViewById(R.id.img_attach);
        imgMessageSend = findViewById(R.id.img_message_send);
        imgBackArrow = findViewById(R.id.img_back_arrow_discussion);

        edtWriteSomething = findViewById(R.id.edt_write_something);

        Bundle extras = getIntent().getExtras();
        if (extras == null)
            caption = null;
        else
            caption = extras.getString("caption");

        txtCaption.setText(caption);

        imgBackArrow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == imgAttach) {

        } else if (view == imgMessageSend) {

        } else if (view == imgBackArrow) {
            Intent intent = new Intent(this, LandingActivity.class);
            startActivity(intent);
        }
    }
}
