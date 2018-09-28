package com.bynry.bpal.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.bynry.bpal.R;


public class ProfileActivity extends AppCompatActivity {

    private LinearLayout linearLayoutCreateProfile, linearLayoutUpper, linearLayoutLower;
    private TextView txtProfile,txtName, txtBirthday, txtAge, txtInterestTechRelated, txtTechRelated, txtInterestHobbies, txtHobbies, txtAboutYourself, txtMax30Words;
    private EditText edtName, edtBirthday, edtAge, edtInterestTechRelated, edtInterestHobbies, edtAboutYourself;
    private Spinner spinnerLocation, spinnerWorkExperience;
    Button btnSkip, btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        linearLayoutCreateProfile = findViewById(R.id.linear_layout_create_profile);
        linearLayoutUpper = findViewById(R.id.linear_layout_upper);
        linearLayoutLower = findViewById(R.id.linear_layout_lower);

        txtProfile = findViewById(R.id.txt_profile);
        txtName = findViewById(R.id.txt_name);
        txtBirthday = findViewById(R.id.txt_birthday);
        txtAge = findViewById(R.id.txt_age);
        txtInterestTechRelated = findViewById(R.id.txt_interest_tech_related);
        txtTechRelated = findViewById(R.id.txt_tech_related);
        txtInterestHobbies = findViewById(R.id.txt_interest_hobbies);
        txtHobbies = findViewById(R.id.txt_hobbies);
        txtAboutYourself = findViewById(R.id.txt_about_yourself);
        txtMax30Words = findViewById(R.id.txt_max_30_words);

        edtName = findViewById(R.id.edt_name);
        edtBirthday = findViewById(R.id.edt_birthday);
        edtAge = findViewById(R.id.edt_age);
        edtInterestTechRelated = findViewById(R.id.edt_interest_tech_related);
        edtInterestHobbies = findViewById(R.id.edt_interest_hobbies);
        edtAboutYourself = findViewById(R.id.edt_about_yourself);

        spinnerLocation = findViewById(R.id.spinner_location);
        spinnerWorkExperience = findViewById(R.id.spinner_work_experience);

        btnSkip = findViewById(R.id.btn_skip);
        btnSubmit = findViewById(R.id.btn_submit);
    }
}
