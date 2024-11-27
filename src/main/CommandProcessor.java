package main;

import main.commands.*;
import main.formatter.Formatter;
import main.formatter.RawFormatter;
import main.paragraph.ParagraphManager;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Processes commands and dispatches them to appropriate handlers.
 */
public class CommandProcessor {
    private ParagraphManager paragraphManager;
    private Formatter formatter;
    private Map<CommandWord, Command> commands;
    private Logger logger;

    /**
     * Constructs a CommandProcessor.
     *
     * @param paragraphManager The ParagraphManager.
     * @param formatter        The Formatter.
     */
    public CommandProcessor(ParagraphManager paragraphManager, Formatter formatter) {
        this.paragraphManager = paragraphManager;
        this.formatter = formatter;
        this.commands = new HashMap<>();
        this.logger = Logger.getLogger("TextEditorLogger");
    }

    /**
     * Dispatches the command to the appropriate handler.
     *
     * @param commandDescription The command description.
     */
    public void dispatchCommand(CommandDescription commandDescription) {
        CommandWord commandWord = commandDescription.getCommandWord();
        int position = commandDescription.getOptionalPosition();
        Command command = null;
        InputValidator inputValidator = new InputValidator();
        switch (commandWord) {
            case ADD:
                command = new AddCommand(paragraphManager, inputValidator, position);
                break;
            case DEL:
                command = new DeleteCommand(paragraphManager, position);
                break;
            case DUMMY:
                command = new DummyCommand(paragraphManager, position);
                break;
            case PRINT:
                command = new PrintCommand(paragraphManager, formatter);
                break;
            case FORMAT_RAW:
                formatter = new RawFormatter();
                break;
            case FORMAT_FIX:
                command = new FormatCommand(this, position);
                break;
            case REPLACE:
                command = new ReplaceCommand(paragraphManager, inputValidator, position);
                break;
            case INDEX:
                command = new IndexCommand(paragraphManager);
                break;
            case EXIT:
                command = new ExitCommand();
                break;
            default:
                // Unknown command is already handled in InputHandler
                break;
        }
        if (command != null) {
            command.execute();
        }
    }

    /**
     * Sets the formatter.
     *
     * @param formatter The Formatter to set.
     */
    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }
}