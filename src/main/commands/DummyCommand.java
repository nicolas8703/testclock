package main.commands;

import main.paragraph.Paragraph;
import main.paragraph.ParagraphManager;

/**
 * Inserts a dummy paragraph at a specified position.
 */
public class DummyCommand implements Command {
    private ParagraphManager paragraphManager;
    private int position = -1;

    /**
     * Initializes the DummyCommand.
     *
     * @param paragraphManager the ParagraphManager instance
     * @param arguments        the command arguments
     * @throws Exception if argument parsing fails
     */
    public DummyCommand(ParagraphManager paragraphManager, String arguments) throws Exception {
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
                throw new Exception("Ungültige Positionsangabe für DUMMY-Befehl.");
            }
        }
    }

    @Override
    public void execute() {
        String dummyText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
        Paragraph paragraph = new Paragraph(dummyText);
        paragraphManager.addParagraph(position, paragraph);
    }
}

