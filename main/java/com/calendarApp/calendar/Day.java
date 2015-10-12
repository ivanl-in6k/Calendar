package com.calendarApp.calendar;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by ivan on 09.10.15.
 */
public class Day {
    private int dayOfMonth;
    private int weekday;
    private int month;

    public Day(int day, int weekday, int month) {
        this.dayOfMonth = day;
        this.weekday = weekday;
        this.month = month;
    }

    public boolean isWeekend() {
        return weekday == Calendar.SATURDAY || weekday == Calendar.SUNDAY;
    }

    public boolean isSunday() {
        return weekday == Calendar.SUNDAY;
    }

    public boolean isToday() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        return dayOfMonth == calendar.get(Calendar.DAY_OF_MONTH) && month == calendar.get(Calendar.MONTH);
    }

    public boolean isCurrentMonth() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        return month == calendar.get(Calendar.MONTH);
    }

}
