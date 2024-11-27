package main;

/**
 * An interface for fetching user input.
 */
public interface InputFetch {
    /**
     * Gets an integer input from the user.
     *
     * @return The integer input.
     */
    int getInt();

    /**
     * Gets a string input from the user.
     *
     * @return The string input.
     */
    String getString();
}
