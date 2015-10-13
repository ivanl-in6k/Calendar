package com.calendarApp;

import com.calendarApp.calendar.Month;
import com.calendarApp.printer.AbstractCalendarPrinter;
import com.calendarApp.printer.ASCIIPrinter;
import com.calendarApp.printer.HTMLPrinter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Calendar;

/**
 * Created by ivan on 09.10.15.
 */
public class Main {
    public static void main(String[] args) {

        AbstractCalendarPrinter calendarPrinter;
        FileOutputStream fileWriter = null;
        try {
            fileWriter = new FileOutputStream("fileCalendar2.html", true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        calendarPrinter = new HTMLPrinter(new PrintStream(fileWriter));
//        calendarPrinter = new ASCIIPrinter(System.out);
        calendarPrinter.printCalendar(new Month(Calendar.OCTOBER));
    }
}
