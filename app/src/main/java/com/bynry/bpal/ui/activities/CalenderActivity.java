package com.bynry.bpal.ui.activities;

import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bynry.bpal.R;

import org.billthefarmer.view.CustomCalendarView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class CalenderActivity extends AppCompatActivity implements View.OnClickListener{

    private FloatingActionButton floatingActionButton;
    private LinearLayout layoutEventDetails;
    private CustomCalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        floatingActionButton = findViewById(R.id.floating_action_list_btn);

        layoutEventDetails = findViewById(R.id.layout_event_details);

        calendarView = findViewById(R.id.calender_view);
        // Show Monday as first date of week
        calendarView.setFirstDayOfWeek(Calendar.MONDAY);

        // Initialize calendar with date
        Calendar currentCalendar = Calendar.getInstance(Locale.getDefault());

        // call refreshCalendar to update calendar the view
        calendarView.refreshCalendar(currentCalendar);

        floatingActionButton.setOnClickListener(this);
        layoutEventDetails.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == floatingActionButton){
            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.remove_event_dialog);

            ImageView imgCloseDialog = dialog.findViewById(R.id.img_close_event_dialog);
            imgCloseDialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            Button btnRemoveEvent = dialog.findViewById(R.id.btn_okay);
            btnRemoveEvent.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            dialog.show();

        }else if (view == layoutEventDetails){
            Intent intent = new Intent(this, EventDescriptionActivity.class);
            startActivity(intent);

        }
    }
}
