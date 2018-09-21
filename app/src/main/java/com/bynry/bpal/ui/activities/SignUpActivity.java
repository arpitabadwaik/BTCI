package com.bynry.bpal.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bynry.bpal.R;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout loginScreen, congratulationsScreen;
    private TextView txtBPal, txtLoginText, txtGooglePlus, txtFacebook, txtCongratulations, txtLoginSuccessful;
    private ImageView imgGooglePlus, imgFaceboook;
    private Button btnCreateProfile;
    private RelativeLayout relativeLayoutFacebook, relativeLayoutGooglePlus, relativeLayoutMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        loginScreen = findViewById(R.id.login_screen);
        congratulationsScreen = findViewById(R.id.congratulations_screen);

        txtBPal = findViewById(R.id.txt_b_pal);
        txtLoginText = findViewById(R.id.txt_login_text);
        txtGooglePlus = findViewById(R.id.txt_google_plus);
        txtFacebook = findViewById(R.id.txt_facebook);
        txtCongratulations = findViewById(R.id.txt_congratulations);
        txtLoginSuccessful = findViewById(R.id.txt_login_successful);

        imgGooglePlus = findViewById(R.id.img_google_plus);
        imgFaceboook = findViewById(R.id.img_facebook);

        btnCreateProfile = findViewById(R.id.btn_create_profile);

        relativeLayoutFacebook= findViewById(R.id.relative_layout_facebook);
        relativeLayoutGooglePlus= findViewById(R.id.relative_layout_google_plus);
        relativeLayoutMain= findViewById(R.id.relative_layout_main);

        relativeLayoutGooglePlus.setOnClickListener(this);
        btnCreateProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == relativeLayoutGooglePlus){
            loginScreen.setVisibility(View.GONE);
            relativeLayoutMain.setBackgroundResource(R.drawable.ic_action_background_congratulations);
            congratulationsScreen.setVisibility(View.VISIBLE);
        }
        else
            if (view == btnCreateProfile){
                Intent intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
            }
    }
}
