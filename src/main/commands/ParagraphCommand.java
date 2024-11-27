package main.commands;

import main.paragraph.ParagraphManager;

/**
 * An abstract class for commands that manipulate paragraphs.
 */
public abstract class ParagraphCommand implements Command {
    protected ParagraphManager paragraphManager;

    /**
     * Constructs a ParagraphCommand.
     *
     * @param paragraphManager The ParagraphManager.
     */
    public ParagraphCommand(ParagraphManager paragraphManager) {
        this.paragraphManager = paragraphManager;
    }
}
