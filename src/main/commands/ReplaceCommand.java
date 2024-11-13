package main.commands;

import main.InputValidator;
import main.paragraph.Paragraph;
import main.paragraph.ParagraphManager;
import java.util.Scanner;

/**
 * Replaces text in a specified paragraph.
 */
public class ReplaceCommand implements Command {
    private ParagraphManager paragraphManager;
    private InputValidator inputValidator;
    private int position = -1;
    private String searchText;
    private String replaceText;

    /**
     * Initializes the ReplaceCommand.
     *
     * @param paragraphManager the ParagraphManager instance
     * @param inputValidator   the InputValidator instance
     * @param arguments        the command arguments
     * @throws Exception if argument parsing fails
     */
    public ReplaceCommand(ParagraphManager paragraphManager, InputValidator inputValidator, String arguments) throws Exception {
        this.paragraphManager = paragraphManager;
        this.inputValidator = inputValidator;
        parseArguments(arguments);
    }

    /**
     * Parses the command arguments.
     *
     * @param arguments the command arguments
     * @throws Exception if argument parsing fails
     */
    private void parseArguments(String arguments) throws Exception {
        if (!arguments.isEmpty()) {
            try {
                position = Integer.parseInt(arguments.trim());
            } catch (NumberFormatException e) {
                throw new Exception("Ungültige Positionsangabe für REPLACE-Befehl.");
            }
        }
        searchText = readInput("Zu finden:");
        replaceText = readInput("Ersetzen mit:");
        searchText = inputValidator.validate(searchText);
        replaceText = inputValidator.validate(replaceText);
    }

    @Override
    public void execute() throws Exception {
        Paragraph paragraph;
        if (position == -1) {
            paragraph = paragraphManager.getLastParagraph();
        } else {
            paragraph = paragraphManager.getParagraph(position);
        }
        paragraph.replaceText(searchText, replaceText);
    }

    /**
     * Reads input from the user with a prompt.
     *
     * @param prompt the input prompt
     * @return the user input
     */
    private String readInput(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
