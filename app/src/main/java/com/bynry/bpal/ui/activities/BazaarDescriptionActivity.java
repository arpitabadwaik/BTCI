package com.bynry.bpal.ui.activities;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bynry.bpal.R;
import com.bynry.bpal.ui.adapters.ImageAdapter;

public class BazaarDescriptionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private Context context;
    static TextView mDotsText[];
    private int mDotsCount;
    private LinearLayout mDotsLayout;
    private ImageView imgBackArrow, imgFrontArrow, imgSaveAd, imgInterested;
    private TextView txtPrice, txtNameOfPoster, txtPostType, txtPostDate, txtPostDuration, txtProductDescription, txtCountOfResponses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bazaar_description);

        imgBackArrow = findViewById(R.id.img_back_arrow_grey);
        imgFrontArrow = findViewById(R.id.img_front_arrow_grey);
        imgInterested = findViewById(R.id.img_interested);
        imgSaveAd = findViewById(R.id.img_save_ad);

        Gallery gallery = findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemSelectedListener(this);

        mDotsLayout = findViewById(R.id.image_count);
        // here we count the number of images we have to know how many dots we
        // need
        mDotsCount = gallery.getAdapter().getCount();

        // here we create the dots
        // as you can see the dots are nothing but "." of large size
        mDotsText = new TextView[mDotsCount];

        // here we set the dots
        for (int i = 0; i < mDotsCount; i++) {
            mDotsText[i] = new TextView(this);
            mDotsText[i].setText(".");
            mDotsText[i].setTextSize(70);
            mDotsText[i].setTypeface(null, Typeface.BOLD);
            mDotsText[i].setTextColor(android.graphics.Color.GRAY);
            mDotsLayout.addView(mDotsText[i]);
        }

        imgBackArrow.setOnClickListener(this);
        imgFrontArrow.setOnClickListener(this);
        imgInterested.setOnClickListener(this);
        imgSaveAd.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView arg0, View arg1, int arg2, long arg3) {
        for (int i = 0; i < mDotsCount; i++) {
            BazaarDescriptionActivity.mDotsText[i].setTextColor(getResources().getColor(R.color.img_slider_round_border_color));
        }
        BazaarDescriptionActivity.mDotsText[arg2].setTextColor(getResources().getColor(R.color.text_color_blue));
    }

    @Override
    public void onNothingSelected(AdapterView arg0) {

    }

    @Override
    public void onClick(View view) {
        if (view == imgBackArrow) {

        } else if (view == imgFrontArrow) {

        } else if (view == imgInterested) {
            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.interested_dialog);

            ImageView imgCloseDialog = dialog.findViewById(R.id.img_close_dialog);
            imgCloseDialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            Button btnOkay = dialog.findViewById(R.id.btn_okay);
            btnOkay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            dialog.show();

        } else if (view == imgSaveAd) {
            LayoutInflater li = getLayoutInflater();
            View layout = li.inflate(R.layout.customized_toast, (ViewGroup) findViewById(R.id.customized_toast_layout));
            Button btnToast = layout.findViewById(R.id.btn_toast);
            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP, 0, 120);
            toast.setView(layout);
            btnToast.setText(R.string.ad_saved_successfully);
            toast.show();
            imgSaveAd.setImageResource(R.drawable.ic_action_save_post_filled);

        }
    }
}

