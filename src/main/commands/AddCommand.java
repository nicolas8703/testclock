package main.commands;

import main.InputValidator;
import main.paragraph.ParagraphManager;

import java.util.Scanner;

/**
 * Handles the ADD command.
 */
public class AddCommand extends ParagraphCommand {
    private int position;
    private String text;
    private InputValidator inputValidator;

    /**
     * Constructs an AddCommand.
     *
     * @param paragraphManager The ParagraphManager.
     * @param inputValidator   The InputValidator.
     * @param position         The position to insert at.
     */
    public AddCommand(ParagraphManager paragraphManager, InputValidator inputValidator, int position) {
        super(paragraphManager);
        this.inputValidator = inputValidator;
        this.position = position;
    }

    /**
     * Executes the ADD command.
     */
    @Override
    public void execute() {
        text = readInput("Text: ");
        if (inputValidator.validateString(text)) {
            if (position >= 0) {
                paragraphManager.addParagraph(position - 1, text);
            } else {
                paragraphManager.addParagraph(-1, text);
            }
        }
    }

    /**
     * Reads input from the user.
     *
     * @param prompt The prompt message.
     * @return The input string.
     */
    private String readInput(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}