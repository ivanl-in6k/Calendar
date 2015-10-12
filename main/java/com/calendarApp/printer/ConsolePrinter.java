package com.calendarApp.printer;

import com.calendarApp.calendar.MonthCalendar;

/**
 * Created by ivan on 09.10.15.
 */
public class ConsolePrinter extends AbstractCalendarPrinter {

    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_BLUE = "\u001B[34m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_RESET = "\u001B[0m";

    public ConsolePrinter(MonthCalendar monthCalendar) {
        super(monthCalendar);
    }

    public void printHeaderCalendar() {
        System.out.println(monthCalendar.getCurrentMonthTitle());
        for (Day day : AbstractCalendarPrinter.Day.values()) {
            System.out.format(DAY_FORMAT, day);
        }
        System.out.println();
    }

    @Override
    protected void beginPrint() {
        printHeaderCalendar();
    }

    @Override
    protected void afterPrint() {
        System.out.print(ANSI_RESET);
    }

    @Override
    protected void setColor(com.calendarApp.calendar.Day day) {
        if (day.isWeekend()) {
            System.out.print(ANSI_RED);
        }
        if (day.isToday()) {
            System.out.print(ANSI_BLUE);
        }
    }

    @Override
    public void print(int day) {
        System.out.printf(DAY_FORMAT, String.valueOf(day));
        System.out.printf(ANSI_RESET);
    }

    protected void println(com.calendarApp.calendar.Day calendarDay) {
        if (calendarDay.isSunday()) {
            System.out.println();
        }
    }
}
