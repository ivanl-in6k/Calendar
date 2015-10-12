package com.calendarApp;

import com.calendarApp.printer.AbstractCalendarPrinter;
import com.calendarApp.printer.ConsolePrinter;
import com.calendarApp.calendar.MonthCalendar;

import java.util.Calendar;

/**
 * Created by ivan on 09.10.15.
 */
public class Main {
    public static void main(String[] args) {
        MonthCalendar monthCalendar = new MonthCalendar(Calendar.OCTOBER);
        AbstractCalendarPrinter calendarPrinter;
//        calendarPrinter = new HTMLPrinter(monthCalendar);
        calendarPrinter = new ConsolePrinter(monthCalendar);
        calendarPrinter.printCalendar();
    }
}
