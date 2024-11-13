package main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Logs commands and errors.
 */
public class Logger {
    private PrintWriter writer;

    /**
     * Initializes the Logger and opens the log file.
     */
    public Logger() {
        try {
            FileWriter fw = new FileWriter("log.txt", true);
            writer = new PrintWriter(fw, true);
        } catch (IOException e) {
            System.err.println("Error initializing the logger.");
        }
    }

    /**
     * Logs an informational message.
     *
     * @param message the message to log
     */
    public void log(String message) {
        writer.println("INFO: " + message);
    }

    /**
     * Logs an error message.
     *
     * @param errorMessage the error message to log
     */
    public void logError(String errorMessage) {
        writer.println("ERROR: " + errorMessage);
    }
}
