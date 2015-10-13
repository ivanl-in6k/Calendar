package com.calendarApp.printer;

import com.calendarApp.calendar.Day;

import javax.swing.text.html.HTML;
import java.io.PrintStream;

/**
* Created by ivan on 09.10.15.
*/
public class HTMLPrinter extends AbstractCalendarPrinter {

    public HTMLPrinter(PrintStream printStream) {
        super(printStream);
    }

    public String html = "";

    @Override
    protected void beforeTablePrint() {
        printStream.print(HTMLTag.HTML + "\n" + HTMLTag.getHead("Calendar 1.1", getCssFilePath()) + "\n" +HTMLTag.BODY);
        printStream.println(HTMLTag.TABLE);
        printStream.println(HTMLTag.createAndSetTRAttributes());
    }

    @Override
    protected void afterTablePrint() {
        String html = "";
        html += HTMLTag.C_TABLE;
        html += HTMLTag.C_BODY + HTMLTag.C_HTML;
        printStream.print(html);
    }


    protected void println() {
//        String html = HTMLTag.C_TR + HTMLTag.TR;

    }

    protected String getColor(Day day) {
        String color;
//        color = day.isDayEqual(14) ? "000099" : "";
        color = day.isWeekend() ?  "#FF0000" : "";
        return color;
    }

    @Override
    protected void openWeek() {
        printStream.print(HTMLTag.TR);
    }

    @Override
    protected void closeWeek() {
        printStream.print(HTMLTag.C_TR);
    }

    @Override
    protected void print(Day day) {
        printStream.printf(HTMLTag.TD_COLOR_ATTR + getColor(day) + HTMLTag.C_TAG + day.getDayOfMonth() + HTMLTag.C_TD);
    }

    @Override
    protected void printDayName(String line) {
        String html = HTMLTag.TD + line + HTMLTag.C_TD;
        printStream.print(line);
    }

    private String getCssFilePath() {
        String path = "main.css";
        String css = "<link rel=\"stylesheet\" type=\"text/css\" href=" + path + ">";
        return css;
    }
}
