package main.commands;

import main.formatter.Formatter;
import main.paragraph.Paragraph;
import main.paragraph.ParagraphManager;

import java.util.List;

/**
 * Prints the paragraphs using the current formatter.
 */
public class PrintCommand implements Command {
    private ParagraphManager paragraphManager;
    private Formatter formatter;

    /**
     * Initializes the PrintCommand.
     *
     * @param paragraphManager the ParagraphManager instance
     * @param formatter        the Formatter instance
     */
    public PrintCommand(ParagraphManager paragraphManager, Formatter formatter) {
        this.paragraphManager = paragraphManager;
        this.formatter = formatter;
    }

    @Override
    public void execute() {
        List<Paragraph> paragraphs = paragraphManager.getAllParagraphs();
        String output = formatter.format(paragraphs);
        System.out.println(output);
    }
}
