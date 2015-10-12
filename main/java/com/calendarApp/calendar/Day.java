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

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getWeekday() {
        return weekday;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }

    public Day(int day, int weekday, int month) {
        this.dayOfMonth = day;
        this.weekday = weekday;
    }

    public boolean isWeekend() {
        return weekday == Calendar.SATURDAY || weekday == Calendar.SUNDAY;
    }

    public boolean isSunday() {
        return weekday == Calendar.SUNDAY;
    }

    public boolean isDayEqual() {
        return false;
    }

    public boolean isInMonth(int month) {
        return false;
    }

}
