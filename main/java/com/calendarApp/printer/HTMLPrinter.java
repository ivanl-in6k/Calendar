package com.calendarApp.printer;

import com.calendarApp.FileWriter;
import com.calendarApp.calendar.Month;

import java.io.IOException;

/**
 * Created by ivan on 09.10.15.
 */
public class HTMLPrinter extends AbstractCalendarPrinter {

    FileWriter fileWriter = new FileWriter();

    private String html = "";

    public HTMLPrinter(Month month) {
        super(month);
    }

    public void printHeaderCalendar() {
        html += "<div class=\"calendarTitle\">" + month.getCurrentMonthTitle() + "</div>";
        html += "<tr>";
        for (Day day : AbstractCalendarPrinter.Day.values()) {
           html += "<th>" + day + "</th>";
        }
        html += "</tr>";
    }

    @Override
    public void beginPrint() {
        html += HTMLTag.HTML + HTMLTag.getHead("Calendar 1.2", inputCssFilePath());
        html += HTMLTag.BODY;
        html += HTMLTag.TABLE + HTMLTag.TR;
        printHeaderCalendar();
    }

    @Override
    protected void afterPrint() {
        html += HTMLTag.C_TABLE;
        html += HTMLTag.C_BODY + HTMLTag.C_HTML;
        try {
            fileWriter.printInFile(html);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void println(com.calendarApp.calendar.Day calendarDay) {
        if (calendarDay.isSunday() == false) return;

        html += HTMLTag.C_TR + HTMLTag.TR;
    }


    @Override
    protected void setColor(com.calendarApp.calendar.Day day) {

    }

    @Override
    protected void print(int day) {
        html += day + "</td>";
    }

    private String inputCssFilePath() {
        String path = "main.css";
        String css = "<link rel=\"stylesheet\" type=\"text/css\" href=" + path + ">";
        return css;
    }
}
