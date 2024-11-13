package main.commands;

import main.InputValidator;
import main.paragraph.Paragraph;
import main.paragraph.ParagraphManager;

import java.util.Scanner;

/**
 * Adds a paragraph at a specified position.
 */
public class AddCommand implements Command {
    private ParagraphManager paragraphManager;
    private InputValidator inputValidator;
    private int position = -1;
    private String text;

    /**
     * Initializes the AddCommand.
     *
     * @param paragraphManager the ParagraphManager instance
     * @param inputValidator   the InputValidator instance
     * @param arguments        the command arguments
     * @throws Exception if argument parsing fails
     */
    public AddCommand(ParagraphManager paragraphManager, InputValidator inputValidator, String arguments) throws Exception {
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
                throw new Exception("Ungültige Positionsangabe für ADD-Befehl.");
            }
        }
        text = readInput("Text eingeben:");
        text = inputValidator.validate(text);
    }

    @Override
    public void execute() {
        Paragraph paragraph = new Paragraph(text);
        paragraphManager.addParagraph(position, paragraph);
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
