package main.commands;

import main.CommandProcessor;
import main.formatter.FixedFormatter;
import main.formatter.RawFormatter;

/**
 * Changes the current formatter based on user input.
 */
public class FormatCommand implements Command {
    private CommandProcessor commandProcessor;
    private String formatType;
    private int columnWidth;

    /**
     * Initializes the FormatCommand.
     *
     * @param commandProcessor the CommandProcessor instance
     * @param arguments        the command arguments
     * @throws Exception if argument parsing fails
     */
    public FormatCommand(CommandProcessor commandProcessor, String arguments) throws Exception {
        this.commandProcessor = commandProcessor;
        parseArguments(arguments);
    }

    /**
     * Parses the command arguments.
     *
     * @param arguments the command arguments
     * @throws Exception if argument parsing fails
     */
    private void parseArguments(String arguments) throws Exception {
        if (arguments.isEmpty()) {
            throw new Exception("FORMAT-Befehl erfordert zusätzliche Parameter.");
        }
        String[] args = arguments.trim().split("\\s+");
        formatType = args[0].toUpperCase();

        if (formatType.equals("FIX")) {
            if (args.length < 2) {
                throw new Exception("FORMAT FIX erfordert eine Spaltenbreite.");
            }
            try {
                columnWidth = Integer.parseInt(args[1]);
                if (columnWidth < 1) {
                    throw new Exception("Die Spaltenbreite muss mindestens 1 sein.");
                }
            } catch (NumberFormatException e) {
                throw new Exception("Ungültige Spaltenbreite für FORMAT FIX.");
            }
        }
    }

    @Override
    public void execute() throws Exception {
        switch (formatType) {
            case "RAW":
                commandProcessor.setFormatter(new RawFormatter());
                break;
            case "FIX":
                commandProcessor.setFormatter(new FixedFormatter(columnWidth));
                break;
            default:
                throw new Exception("Unbekannter FORMAT-Typ: " + formatType);
        }
    }
}
