package main.commands;


import main.paragraph.ParagraphManager;

/**
 * Handles the DELETE command.
 */
public class DeleteCommand extends ParagraphCommand {
    private int position;

    /**
     * Constructs a DeleteCommand.
     *
     * @param paragraphManager The ParagraphManager.
     * @param position         The position to delete.
     */
    public DeleteCommand(ParagraphManager paragraphManager, int position) {
        super(paragraphManager);
        this.position = position;
    }

    /**
     * Executes the DELETE command.
     */
    @Override
    public void execute() {
        if (position >= 0) {
            paragraphManager.deleteParagraph(position - 1);
        } else {
            paragraphManager.deleteParagraph(paragraphManager.getParagraphs().size() - 1);
        }
    }
}