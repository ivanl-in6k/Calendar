package com.calendarApp.calendar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MonthCalendar {

    private Calendar currentCalendar = Calendar.getInstance();
    private Calendar featureCalendar = Calendar.getInstance();

    public MonthCalendar(int month) {
        setCurrentMonth(month);
    }

    public String getCurrentMonthTitle() {
        return new SimpleDateFormat("MMMMMMMM").format(currentCalendar.getTime());
    }

    private void setCurrentMonth(int month) {
        currentCalendar.set(Calendar.MONTH, month);
        currentCalendar.set(Calendar.DAY_OF_MONTH, 1);

        featureCalendar.set(Calendar.MONTH, month);
        featureCalendar.add(Calendar.MONTH, 1);
    }

    public List<Day> getCurrentMonthDays() {
        rollCalendarToFirstDayOfFirstWeek();
        List<Day> month = new ArrayList<>();

        while (!isLastDayOfLastWeekReached()) {
            month.add(createCurrentCalendarDay());
            currentCalendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        currentCalendar.add(Calendar.MONTH, -1);
        return month;
    }

    private Day createCurrentCalendarDay() {
        return new Day(
                currentCalendar.get(Calendar.DAY_OF_MONTH),
                currentCalendar.get(Calendar.DAY_OF_WEEK),
                currentCalendar.get(Calendar.MONTH)
        );
    }

    private void rollCalendarToFirstDayOfFirstWeek() {
        while (!isDayOfWeek(Calendar.MONDAY)) {
            currentCalendar.add(Calendar.DAY_OF_WEEK, -1);
        }
    }

    private boolean isLastDayOfLastWeekReached() {
        return currentCalendar.after(featureCalendar) && isDayOfWeek(Calendar.MONDAY);
    }

    private boolean isDayOfWeek(int dayOfWeek) {
        return currentCalendar.get(Calendar.DAY_OF_WEEK) == dayOfWeek;
    }
}