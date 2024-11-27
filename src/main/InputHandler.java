package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Handles user input and command parsing.
 */
public class InputHandler implements InputFetch {
    private Logger logger;
    private Scanner scanner;
    private Map<String, CommandWord> validCommands;
    private InputValidator inputValidator;

    /**
     * Constructs an InputHandler.
     */
    public InputHandler() {
        this.logger = Logger.getLogger("TextEditorLogger");
        this.scanner = new Scanner(System.in);
        this.inputValidator = new InputValidator();
        validCommands = new HashMap<>();
        for (CommandWord command : CommandWord.values()) {
            validCommands.put(command.name(), command);
        }
    }

    /**
     * Gets the next command from the user.
     *
     * @return A CommandDescription object.
     */
    public CommandDescription getCommand() {
        String inputLine = scanner.nextLine().trim();
        String[] words = inputLine.split("\\s+");
        CommandWord commandWord = validCommands.getOrDefault(words[0].toUpperCase(), CommandWord.UNKNOWN);

        if (commandWord == CommandWord.UNKNOWN) {
            System.err.println("Severe: Unknown command.");
            logger.severe("Severe: Unknown command.");
        }

        int position = -1;
        if (words.length > 1) {
            try {
                position = Integer.parseInt(words[1]);
            } catch (NumberFormatException e) {
                // Ignore invalid number format
            }
        }
        return new CommandDescription(commandWord, position);
    }

    @Override
    public int getInt() {
        return scanner.nextInt();
    }

    @Override
    public String getString() {
        return scanner.nextLine();
    }
}
