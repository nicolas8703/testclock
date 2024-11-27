package main;

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

        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new SimpleFormatter());

        logger.addHandler(handler);
    }
}