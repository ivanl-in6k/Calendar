package com.calendarApp.printer;

import com.calendarApp.calendar.Day;
import com.calendarApp.calendar.Month;

import java.io.PrintStream;

/**
* Created by ivan on 09.10.15.
*/
public class ASCIIPrinter extends AbstractCalendarPrinter {

    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_BLUE = "\u001B[34m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_RESET = "\u001B[0m";

    public ASCIIPrinter(PrintStream printStream) {
        super(printStream);
    }

    @Override
    protected void beforeTablePrint() {
        printStream.println("========= ASCII ==========");
    }
    @Override
    protected void afterTablePrint() {
       printStream.print(ANSI_RESET);
    }

    protected String getColor(Day day) {
        String color = "";
        if (day.isWeekend()) {
            color = ANSI_RED;
        }
//        if (day.isDayEqual(14)) {
//            color = ANSI_BLUE;
//        }
        return color;
    }

    @Override
    protected void openWeek() {
        printStream.print("");
    }

    @Override
    protected void closeWeek() {
        println();
    }

    @Override
    public void print(Day day) {
        printStream.printf(getColor(day));
        printStream.printf(DAY_FORMAT, day.getDayOfMonth());
        printStream.printf(ANSI_RESET);
    }

    protected void printDayName(String line){
        printStream.printf(DAY_FORMAT, line);
    }

    protected void println() {
       printStream.println();
    }
}
