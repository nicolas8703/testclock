package main;

import main.commands.Command;
import main.commands.ExitCommand;
import main.formatter.Formatter;
import main.formatter.RawFormatter;
import main.paragraph.ParagraphManager;

import java.util.Scanner;

/**
 * Manages the main program flow and holds the global state of the application.
 */
public class Application {
    private CommandProcessor commandProcessor;
    private ParagraphManager paragraphManager;
    private Logger logger;
    private Formatter formatter;
    private boolean isRunning;

    /**
     * Initializes the application and its components.
     */
    public Application() {
        logger = new Logger();
        paragraphManager = new ParagraphManager();
        formatter = new RawFormatter();
        commandProcessor = new CommandProcessor(paragraphManager, formatter, logger);
        isRunning = true;
    }

    /**
     * Starts the application and processes user input.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Willkommen zum Texteditor!");

        while (isRunning) {
            System.out.print("> ");
            String inputLine = scanner.nextLine();

            if (!inputLine.trim().isEmpty()) {
                try {
                    Command command = commandProcessor.processCommand(inputLine);
                    command.execute();

                    if (command instanceof ExitCommand) {
                        isRunning = false;
                    }

                    logger.log("Executed command: " + inputLine);
                } catch (Exception e) {
                    System.err.println("Fehler: " + e.getMessage());
                    logger.logError(e.getMessage());
                }
            } else {
                System.out.println("Bitte geben Sie einen Befehl ein.");
            }
        }

        scanner.close();
        System.out.println("Anwendung beendet.");
    }
}
