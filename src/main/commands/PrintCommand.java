package main.commands;

import main.formatter.Formatter;
import main.paragraph.ParagraphManager;

/**
 * Handles the PRINT command.
 */
public class PrintCommand implements Command {
    private ParagraphManager paragraphManager;
    private Formatter formatter;

    /**
     * Constructs a PrintCommand.
     *
     * @param paragraphManager The ParagraphManager.
     * @param formatter        The Formatter.
     */
    public PrintCommand(ParagraphManager paragraphManager, Formatter formatter) {
        this.paragraphManager = paragraphManager;
        this.formatter = formatter;
    }

    /**
     * Executes the PRINT command.
     */
    @Override
    public void execute() {
        String output = formatter.format(paragraphManager.getParagraphs());
        System.out.println(output);
    }
}