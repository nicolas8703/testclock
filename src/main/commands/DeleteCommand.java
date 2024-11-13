package main.commands;

import main.paragraph.ParagraphManager;
/**
 * Deletes a paragraph at a specified position.
 */
public class DeleteCommand implements Command {
    private ParagraphManager paragraphManager;
    private int position = -1;

    /**
     * Initializes the DeleteCommand.
     *
     * @param paragraphManager the ParagraphManager instance
     * @param arguments        the command arguments
     * @throws Exception if argument parsing fails
     */
    public DeleteCommand(ParagraphManager paragraphManager, String arguments) throws Exception {
        this.paragraphManager = paragraphManager;
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
                throw new Exception("Ungültige Positionsangabe für DEL-Befehl.");
            }
        }
    }

    @Override
    public void execute() throws Exception {
        paragraphManager.deleteParagraph(position);
    }
}
