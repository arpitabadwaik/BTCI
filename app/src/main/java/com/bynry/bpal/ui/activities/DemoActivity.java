package com.bynry.bpal.ui.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bynry.bpal.R;
import com.bynry.bpal.ui.fragments.BazaarFragment;
import com.bynry.bpal.ui.fragments.ConnectFragment;
import com.bynry.bpal.ui.fragments.TechBitesFragment;
import com.bynry.bpal.ui.fragments.WhatsUpFragment;

public class DemoActivity extends AppCompatActivity {

    private int currentSelected = 0;
    private String intro="intro", product = "product", location = "location", login = "login";

    private ImageView ivIntro, ivProduct, ivLocation, ivLogin;
    private TextView tvIntro, tvProduct, tvLocation, tvLogin;
    private LinearLayout llIntro, llProduct, llLocation, llLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        llIntro = findViewById(R.id.llIntro);
        llProduct =  findViewById(R.id.llProduct);
        llLocation =  findViewById(R.id.llLocation);
        llLogin = findViewById(R.id.llLogin);

        ivIntro = (ImageView) findViewById(R.id.ivIntro);
        ivProduct = (ImageView) findViewById(R.id.ivProduct);
        ivLocation = (ImageView) findViewById(R.id.ivLocation);
        ivLogin = (ImageView) findViewById(R.id.ivLogin);

        tvIntro = (TextView) findViewById(R.id.tvIntro);
        tvProduct = (TextView) findViewById(R.id.tvProduct);
        tvLocation = (TextView) findViewById(R.id.tvLocation);
        tvLogin = (TextView) findViewById(R.id.tvLogin);

        llIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentSelected == 1){

                }else {
                    getSupportActionBar().setTitle("What's Up?");
                    ivIntro.setImageResource(R.drawable.ic_action_whats_up_after_click);
                    tvIntro.setTextColor(getResources().getColor(R.color.white));
                    llIntro.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_action_b_pal_white));
                    unselectElse(1);
                    removeAllFragment(new WhatsUpFragment(), false,intro);
                }
            }
        });

        llProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentSelected == 2){

                }else {
                    getSupportActionBar().setTitle("Tech Bites");
                    ivProduct.setImageResource(R.drawable.ic_action_tech_bites_after_click);
                    tvProduct.setTextColor(getResources().getColor(R.color.white));
                    llProduct.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    unselectElse(2);
                    removeAllFragment(new TechBitesFragment(), false, product);
                }
            }
        });

        llLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentSelected == 3){

                }else {
                    getSupportActionBar().setTitle("Bazaar");
                    ivLocation.setImageResource(R.drawable.ic_action_bazaar_after_click);
                    tvLocation.setTextColor(getResources().getColor(R.color.white));
                    llLocation.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    unselectElse(3);
                    removeAllFragment(new BazaarFragment(), false, location);
                }
            }
        });

        llLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentSelected == 4){

                }else {
                    getSupportActionBar().setTitle("Connect");
                    ivLogin.setImageResource(R.drawable.ic_action_connect_after_click);
                    tvLogin.setTextColor(getResources().getColor(R.color.white));
                    llLogin.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_action_b_pal_white));
                    unselectElse(4);
                    removeAllFragment(new ConnectFragment(), false, login);
                }
            }
        });

    }

    private void unselectElse(int current){
        switch (currentSelected){
            case 1:
                ivIntro.setImageResource(R.drawable.ic_action_facebook);
                tvIntro.setTextColor(getResources().getColor(R.color.colorPrimary));
                llIntro.setBackgroundColor(getResources().getColor(R.color.black));
                currentSelected = current;
                break;
            case 2:
                ivProduct.setImageResource(R.drawable.ic_action_facebook);
                tvProduct.setTextColor(getResources().getColor(R.color.colorPrimary));
                llProduct.setBackgroundColor(getResources().getColor(R.color.black));
                currentSelected = current;
                break;
            case 3:
                ivLocation.setImageResource(R.drawable.ic_action_facebook);
                tvLocation.setTextColor(getResources().getColor(R.color.colorPrimary));
                llLocation.setBackgroundColor(getResources().getColor(R.color.black));
                currentSelected = current;
                break;
            case 4:
                ivLogin.setImageResource(R.drawable.ic_action_facebook);
                tvLogin.setTextColor(getResources().getColor(R.color.colorPrimary));
                llLogin.setBackgroundColor(getResources().getColor(R.color.black));
                currentSelected = current;
                break;
        }
        if(currentSelected == 0){
            currentSelected = current;
        }
    }

    public void removeAllFragment(Fragment replaceFragment, boolean addToBackStack, String tag) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        manager.popBackStackImmediate(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);

        if (addToBackStack) {
            ft.addToBackStack(tag);
        }
        ft.replace(R.id.container_body, replaceFragment);
        ft.commitAllowingStateLoss();
    }
}
