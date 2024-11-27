package main.commands;

import main.CommandProcessor;
import main.formatter.FixedFormatter;
import main.formatter.Formatter;


/**
 * Handles the FORMAT command.
 */
public class FormatCommand implements Command {
    private CommandProcessor commandProcessor;
    private int columnWidth;

    /**
     * Constructs a FormatCommand.
     *
     * @param commandProcessor The CommandProcessor.
     * @param columnWidth      The column width.
     */
    public FormatCommand(CommandProcessor commandProcessor, int columnWidth) {
        this.commandProcessor = commandProcessor;
        this.columnWidth = columnWidth;
    }

    /**
     * Executes the FORMAT command.
     */
    @Override
    public void execute() {
        Formatter formatter = new FixedFormatter(columnWidth);
        commandProcessor.setFormatter(formatter);
    }
}