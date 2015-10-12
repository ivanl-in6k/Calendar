package com.calendarApp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ivan on 11.10.15.
 */
public class FileWriter {
    private  String fileName;

    public FileWriter() {
        this.fileName = "fileCalendar.html";
    }

    public FileWriter(String fileName) {
        this.fileName = fileName;
    }

    public void printInFile(String line) throws IOException {
        PrintWriter printWriter = new PrintWriter(createFile(fileName));
        printWriter.print(line);
        printWriter.close();
    }

    private File createFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }
}
