package com.bynry.bpal.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bynry.bpal.R;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout linearLayoutAppBar, linearLayoutLower;
    private RelativeLayout layoutUpper, layoutUpperLeft;
    private ImageView imgBackArrow, imgProfilePicture, imgEditPicture, imgSingleBadge;
    private TextView txtUserNameProfile, txtName, txtEmail, txtShowEmail, txtMobile, txtShowMobile, txtInterests, txtShow_interests, txtMore, txtMediaCount, txtPostsCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        linearLayoutAppBar = findViewById(R.id.linear_layout_app_bar);
        linearLayoutLower = findViewById(R.id.linear_layout_lower);

        layoutUpper = findViewById(R.id.layout_upper);
        layoutUpperLeft = findViewById(R.id.layout_upper_left);

        imgBackArrow = findViewById(R.id.img_back_arrow_profile);
        imgProfilePicture = findViewById(R.id.circle_img_profile_picture);
        imgEditPicture = findViewById(R.id.img_edit_picture);
        imgSingleBadge = findViewById(R.id.img_single_badge);

        txtUserNameProfile = findViewById(R.id.txt_user_name_profile);
        txtName = findViewById(R.id.txt_name);
        txtEmail = findViewById(R.id.txt_email);
        txtShowEmail = findViewById(R.id.txt_show_email);
        txtMobile = findViewById(R.id.txt_mobile);
        txtShowMobile = findViewById(R.id.txt_show_mobile);
        txtInterests = findViewById(R.id.txt_interest);
        txtShow_interests = findViewById(R.id.txt_show_interests);
        txtMore = findViewById(R.id.txt_more);
        txtMediaCount = findViewById(R.id.txt_media_count);
        txtPostsCount = findViewById(R.id.txt_posts_count);

        imgBackArrow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == imgBackArrow) {
            Intent intent = new Intent(this, LandingActivity.class);
            startActivity(intent);
        }
    }
}
