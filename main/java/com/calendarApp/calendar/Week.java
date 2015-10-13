package com.calendarApp.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ivan on 12.10.15.
 */
public class Week {
//    private int month;
    private List<Day> days = new ArrayList<>();

    public List<Day> getDays() {
        return days;
    }

    public List<Day> createDay(int dayOfMonth, int dayOfWeek) {
        Day day = new Day(dayOfMonth, dayOfWeek);
        days.add(day);
        return days;
    }

    @Override
    public String toString() {
        String daysAsString = new String();
        for(Day day : days) {
            daysAsString += "  " + day.getDayOfMonth();
        }
        return daysAsString;
    }
}
