package com.bynry.bpal.ui.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bynry.bpal.R;
import com.bynry.bpal.ui.fragments.OpenImageVideoFragment;

public class TechBitesMoreActivity extends AppCompatActivity implements View.OnClickListener, OpenImageVideoFragment.OnFragmentInteractionListener {

    private FrameLayout mainFrameLayout;
    private TextView txtHeadingText, txtDateOfPost, txtDescriptionText, txtLike, txtComment, txtSavePost;
    private ImageView imgLike, imgComment, imgSave, imgSendMessage;
    private EditText edtWriteSomething;
    private ImageView image1, image2;
    private CardView cardViewComment;

    // In Fragment OpenImageVideoFragment
    private ImageView imgCloseFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_bites_more);

        mainFrameLayout = findViewById(R.id.main_frame_layout);

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
        image2 = findViewById(R.id.video_view);
        image2.setScaleType(ImageView.ScaleType.FIT_XY);

        cardViewComment = findViewById(R.id.card_comments);

        LayoutInflater li = getLayoutInflater();
        View view = li.inflate(R.layout.fragment_open_image_video, (ViewGroup) findViewById(R.id.frame_layout));
        imgCloseFragment = view.findViewById(R.id.img_close_fragment);

        imgLike.setOnClickListener(this);
        imgComment.setOnClickListener(this);
        imgSave.setOnClickListener(this);
        image1.setOnClickListener(this);
        imgCloseFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == imgSave) {
            LayoutInflater li = getLayoutInflater();
            View layout = li.inflate(R.layout.customized_toast, (ViewGroup) findViewById(R.id.customized_toast_layout));
            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 220);
            toast.setView(layout);//setting the view of custom toast layout
            toast.show();
            imgSave.setImageResource(R.drawable.ic_action_save_post_filled);

        } else if (view == imgComment) {
            cardViewComment.setVisibility(View.VISIBLE);

        } else if (view == imgLike) {
            imgLike.setImageResource(R.drawable.ic_action_like_orange_filled);

        } else if (view == image1) {
            FragmentManager fm = getSupportFragmentManager();
            OpenImageVideoFragment openImageVideoFragment = OpenImageVideoFragment.newInstance();
            openImageVideoFragment.show(fm, "");

        } else if (view == imgCloseFragment) {
            Intent intent = new Intent(this, TechBitesMoreActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
