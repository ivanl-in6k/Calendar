package com.calendarApp.printer;

import com.calendarApp.calendar.MonthCalendar;

import java.util.List;

/**
 * Created by ivan on 09.10.15.
 */
public abstract class AbstractCalendarPrinter {

    protected final String DAY_FORMAT = "%6s";

    protected MonthCalendar monthCalendar;

    protected enum Day {MON, TUE, WEN, THU, FRI, SAT, SUN};

    public AbstractCalendarPrinter(MonthCalendar monthCalendar) {
        this.monthCalendar = monthCalendar;
    }

    protected abstract void beginPrint();

    protected abstract void afterPrint();

    protected abstract void setColor(com.calendarApp.calendar.Day calendarDay);

//    protected void printHeaderCalendar(){
////        System.out.println(monthCalendar.getCurrentMonthTitle());
//        for (Day day : Day.values()) {
//            print(DAY_FORMAT, day);
//        }
//        println();
//    }

    public void printCalendar() {
        List<com.calendarApp.calendar.Day> calendarDays = monthCalendar.getCurrentMonthDays();
        beginPrint();
        for (com.calendarApp.calendar.Day calendarDay : calendarDays) {
            setColor(calendarDay);
            print(calendarDay.);
            println(calendarDay);
        }
        afterPrint();
    }

    protected abstract void println(com.calendarApp.calendar.Day calendarDay);

    protected abstract void print(int day);

}
