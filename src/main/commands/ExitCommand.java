package main.commands;

/**
 * Handles the EXIT command.
 */
public class ExitCommand implements Command {
    /**
     * Executes the EXIT command.
     */
    @Override
    public void execute() {
        System.exit(0);
    }
}


