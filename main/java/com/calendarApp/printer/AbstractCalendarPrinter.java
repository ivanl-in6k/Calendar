package com.calendarApp.printer;

import com.calendarApp.calendar.Day;
import com.calendarApp.calendar.Month;
import com.calendarApp.calendar.Week;

import java.io.PrintStream;
import java.text.DateFormatSymbols;
import java.util.List;

/**
* Created by ivan on 09.10.15.
*/
public abstract class AbstractCalendarPrinter {

    protected abstract void openWeek();
    protected abstract void closeWeek();
    protected abstract void printDayName(String line);
    protected abstract void print(Day day);
    protected abstract void println();
    protected abstract void beforeTablePrint();
    protected abstract void afterTablePrint();

    protected final int FIRST_LETTER = 0;
    protected static final String DAY_FORMAT = "%6s";

    protected final int LAST_LETTER = 3;

    protected PrintStream printStream;

    public AbstractCalendarPrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    protected void printCalendarHeader() {
        String[] weekdays = new DateFormatSymbols().getWeekdays();
        openWeek();
        for(String s: weekdays){
            printDayName(cutString(s));
        }
        closeWeek();
    }

    String cutString(String s) {
        if(s.length() > LAST_LETTER) return s.substring(FIRST_LETTER, LAST_LETTER);
        return s;
    }

    public void printCalendar(Month month) {
        List<Week> weeks = month.getWeeks();
        beforeTablePrint();
        printCalendarHeader();
        for (Week week : weeks) {
            openWeek();
            for (Day day : week.getDays()) {
                print(day);
            }
            closeWeek();
        }
        afterTablePrint();
    }

}
