package main.commands;

import main.IndexGenerator;
import main.paragraph.ParagraphManager;


/**
 * Handles the INDEX command.
 */
public class IndexCommand implements Command {
    private ParagraphManager paragraphManager;

    /**
     * Constructs an IndexCommand.
     *
     * @param paragraphManager The ParagraphManager.
     */
    public IndexCommand(ParagraphManager paragraphManager) {
        this.paragraphManager = paragraphManager;
    }

    /**
     * Executes the INDEX command.
     */
    @Override
    public void execute() {
        IndexGenerator indexGenerator = new IndexGenerator();
        indexGenerator.generateIndex(paragraphManager.getParagraphs());
    }
}