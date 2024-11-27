package main;

import java.io.IOException;
import java.util.logging.*;

/**
 * Configures and provides the Logger instance.
 */
public class LoggingConfig {
    private Logger logger;

    /**
     * Constructs a LoggingConfig and configures the logger.
     */
    public LoggingConfig() {
        configureLogger();
    }

    /**
     * Returns the configured Logger instance.
     *
     * @return The Logger.
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * Configures the logger.
     */
    private void configureLogger() {
        logger = Logger.getLogger("TextEditorLogger");
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);

        try {
            // Create a FileHandler to write logs to "texteditor.log"
            FileHandler fileHandler = new FileHandler("texteditor.log", true);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());

            // Add the FileHandler to the logger
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            System.err.println("Severe: Failed to set up logger handler.");
            logger.severe("Severe: Failed to set up logger handler.");
        }
    }
}