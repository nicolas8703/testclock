package main.commands;

/**
 * Exits the application.
 */
public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Programm wird beendet.");
    }
}


