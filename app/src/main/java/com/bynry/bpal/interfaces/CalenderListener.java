package com.bynry.bpal.interfaces;

import java.util.Calendar;

public interface CalenderListener {

    void onDateSelected(Calendar date);
    void onMonthChanged(Calendar date);

}
