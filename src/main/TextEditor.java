package main;

import main.formatter.Formatter;
import main.formatter.RawFormatter;
import main.paragraph.ParagraphManager;


import java.util.logging.Logger;


/**
 * The main class for the TextEditor application.
 */
public class TextEditor {
    private CommandProcessor commandProcessor;
    private InputHandler inputHandler;
    private Logger logger;
    private boolean isRunning;

    /**
     * Constructs a new TextEditor.
     */
    public TextEditor() {
        LoggingConfig loggingConfig = new LoggingConfig();
        this.logger = loggingConfig.getLogger();

        ParagraphManager paragraphManager = new ParagraphManager();
        this.inputHandler = new InputHandler();
        Formatter formatter = new RawFormatter();
        this.commandProcessor = new CommandProcessor(paragraphManager, formatter);
        this.isRunning = true;
    }

    /**
     * The main method to run the TextEditor.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.mainLoop();
    }

    /**
     * The main loop that runs the application.
     */
    public void mainLoop() {
        while (isRunning) {
            System.out.print("> ");
            CommandDescription commandDescription = inputHandler.getCommand();
            logger.info("Executed: " + commandDescription.getCommandWord().name());
            if (commandDescription.getCommandWord() == CommandWord.EXIT) {
                isRunning = false;
            }
            commandProcessor.dispatchCommand(commandDescription);
        }
    }
}