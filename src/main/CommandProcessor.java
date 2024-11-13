package main;

import main.commands.*;
import main.formatter.Formatter;
import main.paragraph.ParagraphManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Parses user input and creates corresponding Command objects for execution.
 */
public class CommandProcessor {
    private Map<String, CommandFactory> commandFactoryMap;
    private ParagraphManager paragraphManager;
    private Formatter formatter;
    private Logger logger;
    private InputValidator inputValidator;

    /**
     * Initializes the CommandProcessor with required dependencies.
     *
     * @param paragraphManager the ParagraphManager instance
     * @param formatter        the current Formatter instance
     * @param logger           the Logger instance
     */
    public CommandProcessor(ParagraphManager paragraphManager, Formatter formatter, Logger logger) {
        this.paragraphManager = paragraphManager;
        this.formatter = formatter;
        this.logger = logger;
        this.inputValidator = new InputValidator();
        this.commandFactoryMap = new HashMap<>();

        registerCommandFactories();
    }

    /**
     * Registers available command factories.
     */
    private void registerCommandFactories() {
        commandFactoryMap.put("ADD", args -> new AddCommand(paragraphManager, inputValidator, args));
        commandFactoryMap.put("DEL", args -> new DeleteCommand(paragraphManager, args));
        commandFactoryMap.put("DUMMY", args -> new DummyCommand(paragraphManager, args));
        commandFactoryMap.put("EXIT", args -> new ExitCommand());
        commandFactoryMap.put("FORMAT", args -> new FormatCommand(this, args));
        commandFactoryMap.put("INDEX", args -> new IndexCommand(paragraphManager));
        commandFactoryMap.put("PRINT", args -> new PrintCommand(paragraphManager, formatter));
        commandFactoryMap.put("REPLACE", args -> new ReplaceCommand(paragraphManager, inputValidator, args));
    }

    /**
     * Processes the input line and returns the corresponding Command object.
     *
     * @param inputLine the user input line
     * @return the Command object to execute
     * @throws Exception if the command is invalid
     */
    public Command processCommand(String inputLine) throws Exception {
        String[] tokens = inputLine.trim().split("\\s+", 2);
        String commandName = tokens[0].toUpperCase();
        String arguments = tokens.length > 1 ? tokens[1] : "";

        CommandFactory factory = commandFactoryMap.get(commandName);
        if (factory != null) {
            return factory.createCommand(arguments);
        } else {
            throw new Exception("Unbekannter Befehl");
        }
    }

    /**
     * Gets the current Formatter.
     *
     * @return the Formatter instance
     */
    public Formatter getFormatter() {
        return formatter;
    }

    /**
     * Sets the current Formatter.
     *
     * @param formatter the Formatter instance to set
     */
    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }

    /**
     * Functional interface for creating Command instances.
     */
    @FunctionalInterface
    private interface CommandFactory {
        Command createCommand(String arguments) throws Exception;
    }
}
