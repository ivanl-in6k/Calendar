package com.calendarApp.printer;

import java.util.List;

/**
 * Created by ivan on 12.10.15.
 */
public class HTMLTag {
    public static final String HTML = "<html>";
    public static final String C_HTML = "</html>";

    public static final String HEAD = "<head>";
    public static final String C_HEAD = "</head>";

    public static final String TITLE = "<title>";
    public static final String C_TITLE = "</title>";

    public static final String BODY = "<body>";
    public static final String C_BODY = "</body>";

    public static final String TABLE = "<table>";
    public static final String C_TABLE = "</table>";

    public static final String TR = "<tr>";
    public static final String C_TR = "</tr>";

    public static final String TD = "<td>";
    public static final String C_TD = "</td>";
    public static final  String TD_COLOR_ATTR = "<td bgcolor=";
    public static final  String C_TAG = ">";

    public static String getHead(String title, String ... tags) {
        String head = HEAD + TITLE + title + C_TITLE;
        for(String tag : tags) {
            head += tag;
        }
        head += C_HEAD;
        return head;
    }

    public  static String createAndSetTDAttributes(String ... attributes) {
        String td = "<td";
        for (String attribute : attributes) {
            td += attribute;
        }
        td += C_TD;
        return td;
    }

    public  static String createAndSetTRAttributes(String ... attributes) {
        String tr = "<tr";
        for (String attribute : attributes) {
            tr += attribute;
        }
        tr += C_TR;
        return tr;
    }
}
