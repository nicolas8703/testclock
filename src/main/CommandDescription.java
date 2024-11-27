package main;

/**
 * Represents a command description parsed from user input.
 */
public class CommandDescription {
    private final CommandWord commandWord;
    private final int optionalPosition;

    /**
     * Constructs a CommandDescription with a command word and position.
     *
     * @param commandWord     The command word.
     * @param optionalPosition The optional position.
     */
    public CommandDescription(CommandWord commandWord, int optionalPosition) {
        this.commandWord = commandWord;
        this.optionalPosition = optionalPosition;
    }

    /**
     * Gets the command word.
     *
     * @return The command word.
     */
    public CommandWord getCommandWord() {
        return commandWord;
    }

    /**
     * Gets the optional position.
     *
     * @return The optional position.
     */
    public int getOptionalPosition() {
        return optionalPosition;
    }
}
