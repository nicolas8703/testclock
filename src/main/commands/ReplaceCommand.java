package main.commands;

import main.InputValidator;
import main.paragraph.ParagraphManager;
import java.util.Scanner;

/**
 * Handles the REPLACE command.
 */
public class ReplaceCommand extends ParagraphCommand {
    private int position;
    private String searchText;
    private String replaceText;
    private InputValidator inputValidator;

    /**
     * Constructs a ReplaceCommand.
     *
     * @param paragraphManager The ParagraphManager.
     * @param inputValidator   The InputValidator.
     * @param position         The paragraph position.
     */
    public ReplaceCommand(ParagraphManager paragraphManager, InputValidator inputValidator, int position) {
        super(paragraphManager);
        this.inputValidator = inputValidator;
        this.position = position;
    }

    /**
     * Executes the REPLACE command.
     */
    @Override
    public void execute() {
        String paragraph;
        if (position >= 0) {
            paragraph = paragraphManager.getParagraph(position - 1);
        } else {
            paragraph = paragraphManager.getLastParagraph();
        }
        if (paragraph != null) {
            searchText = readInput("Zu finden: ");
            replaceText = readInput("Ersetzen mit: ");
            if (inputValidator.validateString(searchText) && inputValidator.validateString(replaceText)) {
                paragraph = paragraph.replace(searchText, replaceText);
                if (position >= 0) {
                    paragraphManager.getParagraphs().set(position - 1, paragraph);
                } else {
                    paragraphManager.getParagraphs().set(paragraphManager.getParagraphs().size() - 1, paragraph);
                }
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
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
