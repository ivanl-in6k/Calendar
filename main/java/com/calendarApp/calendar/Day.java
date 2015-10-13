package com.calendarApp.calendar;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by ivan on 09.10.15.
 */
public class Day {
    private int dayOfMonth;
    private int weekday;

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public int getWeekday() {
        return weekday;
    }

    public Day(int day, int weekday) {
        this.dayOfMonth = day;
        this.weekday = weekday;
    }

    public boolean isWeekend() {
        return weekday == Calendar.SATURDAY || weekday == Calendar.SUNDAY;
    }

    public boolean isMonday() {
        return weekday == Calendar.MONDAY;
    }

    public boolean isDayEqual(int day) {
       return this.dayOfMonth == day;
    }

    public boolean isInMonth(int month) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        return month == calendar.get(Calendar.MONTH);
    }

}
