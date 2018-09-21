package com.bynry.bpal.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.bynry.bpal.R;

public class ProfileActivity extends AppCompatActivity {

    private Spinner spinnerLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        spinnerLocation = findViewById(R.id.spinner_location);
    }
}
