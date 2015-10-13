package com.calendarApp.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Month {
    private List<Week> weeks = new ArrayList<>();

    private Calendar featureMonth = Calendar.getInstance();
    private Calendar currentMonth = Calendar.getInstance();

    public Month(int month) {
        setCurrentMonth(month);
        setFeatureMonth(month);
        rollMonthToFirstDayOfFirstWeek();
        createMonthWeeks();
    }

    public List<Week> getWeeks() {
        return weeks;
    }

    private void setCurrentMonth(int month) {
        currentMonth.set(Calendar.MONTH, month);
        currentMonth.set(Calendar.DAY_OF_MONTH, 1);
    }

    private void setFeatureMonth(int month) {
        featureMonth.set(Calendar.MONTH, month);
        featureMonth.set(Calendar.DAY_OF_MONTH, 1);
        featureMonth.add(Calendar.MONTH, 1);
    }

    private void rollMonthToFirstDayOfFirstWeek() {
        Week w0eek = new Week();
        while (!isDayOfWeek(Calendar.MONDAY)) {
            currentMonth.add(Calendar.DAY_OF_WEEK, -1);
        }
    }

    private void createMonthWeeks() {
        Week week = new Week();
        while(!isLastDayOfLastWeekReached()) {
           if(isDayOfWeek(Calendar.MONDAY)) {
               week = new Week();
               week.createDay(currentMonth.get(Calendar.DAY_OF_MONTH), currentMonth.get(Calendar.DAY_OF_WEEK));
               weeks.add(week);
           } else {
               week.createDay(currentMonth.get(Calendar.DAY_OF_MONTH), currentMonth.get(Calendar.DAY_OF_WEEK));
           }
           currentMonth.add(Calendar.DAY_OF_MONTH, 1);
        }
    }

    private boolean isLastDayOfLastWeekReached() {
        return currentMonth.after(featureMonth) && isDayOfWeek(Calendar.MONDAY);
    }

    private boolean isDayOfWeek(int day) {
        return currentMonth.get(Calendar.DAY_OF_WEEK) == day;
    }

}