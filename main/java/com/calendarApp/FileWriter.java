package com.calendarApp;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Created by ivan on 11.10.15.
 */
public class FileWriter {
    private  String fileName;
    private PrintStream printStream;

    public FileWriter() {
        this.fileName = "fileCalendar2.html";
    }

    public FileWriter(String fileName) {
        this.fileName = fileName;
    }

    public PrintStream createPrintStream(String line) throws IOException {
        printStream = new PrintStream(createFile());
        return printStream;
    }

    public void printStreamClose() {

    }

    private File createFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    private File createFile() throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }
}
