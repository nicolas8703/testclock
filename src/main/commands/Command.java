package main.commands;

/**
 * Defines the interface for all commands.
 */
public interface Command {

    /**
     * Executes the command.
     *
     * @throws Exception if an error occurs during execution
     */
    void execute() throws Exception;
}
