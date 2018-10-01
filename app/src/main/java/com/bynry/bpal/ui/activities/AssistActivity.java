package com.bynry.bpal.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bynry.bpal.R;

public class AssistActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgBackArrow;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assist);

        imgBackArrow = findViewById(R.id.img_back_arrow);
    }

    @Override
    public void onClick(View view) {
        if (view == imgBackArrow){
            Intent intent = new Intent(this, LandingActivity.class);
            startActivity(intent);
        }
    }
}
