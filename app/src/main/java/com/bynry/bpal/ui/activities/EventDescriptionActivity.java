package com.bynry.bpal.ui.activities;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bynry.bpal.R;

public class EventDescriptionActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgbackArrow, imgEventImage, imgToAttend, imgMeassageSend;
    private TextView txtEventTitle, txtEventDescription, txtNoOfPeopleAttendingEvent;
    private EditText edtWriteSomething;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_description);

        imgbackArrow = findViewById(R.id.img_back_arrow_calender);
        imgEventImage = findViewById(R.id.img_event_image);
        imgToAttend = findViewById(R.id.img_to_attend);
        imgMeassageSend = findViewById(R.id.img_message_send_calender);

        txtEventTitle = findViewById(R.id.txt_event_title);
        txtEventDescription = findViewById(R.id.txt_event_description);
        txtNoOfPeopleAttendingEvent = findViewById(R.id.txt_no_of_people_attending_event);

        edtWriteSomething = findViewById(R.id.edt_write_something_calender);

        imgToAttend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == imgToAttend){

            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.attending_dialog);

            ImageView imgCloseDialog = dialog.findViewById(R.id.img_close_attending_dialog);
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

        }
    }
}
