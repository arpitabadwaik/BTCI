package com.bynry.bpal.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bynry.bpal.R;

public class StartDiscussionActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout layoutHeader;
    private ImageView imgBackArrow, imgAttach;
    private TextView txtWhatsUp;
    private EditText edtSubject, edtRelatedKeywords, edtCompose, edtContactNo;
    private Button btnSubmit;
    private RadioGroup radioGroup;
    private String bazaar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_discussion);

        layoutHeader = findViewById(R.id.layout_header);

        imgBackArrow = findViewById(R.id.img_back_arrow_start_discussion);
        imgAttach = findViewById(R.id.img_attach);

        txtWhatsUp = findViewById(R.id.txt_whats_up);

        edtSubject = findViewById(R.id.edt_subject);
        edtRelatedKeywords = findViewById(R.id.edt_related_keywords);
        edtCompose = findViewById(R.id.edt_compose);
        edtContactNo = findViewById(R.id.edt_contact_no);

        btnSubmit = findViewById(R.id.btn_discussion_submit);

        radioGroup = findViewById(R.id.radio_group);

        Bundle extras = getIntent().getExtras();
        if (extras == null)
            bazaar = null;
        else {
            bazaar = extras.getString("bazaar");
            txtWhatsUp.setText("Post Ad");
            edtContactNo.setVisibility(View.VISIBLE);
            radioGroup.setVisibility(View.VISIBLE);
            btnSubmit.setText("Post");
        }

        imgBackArrow.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if (view == btnSubmit){

        }else if (view == imgBackArrow){
            Intent intent = new Intent(this, LandingActivity.class);
            startActivity(intent);
        }
    }
}
