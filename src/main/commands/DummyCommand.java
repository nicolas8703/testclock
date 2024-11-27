package main.commands;

import main.paragraph.ParagraphManager;

/**
 * Handles the DUMMY command.
 */
public class DummyCommand extends ParagraphCommand {
    private int position;
    private String dummyText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";

    /**
     * Constructs a DummyCommand.
     *
     * @param paragraphManager The ParagraphManager.
     * @param position         The position to insert at.
     */
    public DummyCommand(ParagraphManager paragraphManager, int position) {
        super(paragraphManager);
        this.position = position;
    }

    /**
     * Executes the DUMMY command.
     */
    @Override
    public void execute() {
        if (position >= 0) {
            paragraphManager.addParagraph(position - 1, dummyText);
        } else {
            paragraphManager.addParagraph(-1, dummyText);
        }
    }
}