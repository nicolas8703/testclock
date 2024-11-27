package main;

import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * Validates input strings and integers.
 */
public class InputValidator {
    private Logger logger;

    /**
     * Constructs an InputValidator.
     */
    public InputValidator() {
        this.logger = Logger.getLogger("TextEditorLogger");
    }

    /**
     * Validates a string against allowed characters.
     *
     * @param input The input string.
     * @return True if valid, false otherwise.
     */
    public boolean validateString(String input) {
        String pattern = "^[a-zA-Z0-9äöüÄÖÜ.,:;\\-!? '\\(\\)\"%@+*\\[\\]{}/\\\\&#$]*$";
        boolean isValid = Pattern.matches(pattern, input);
        if (!isValid) {
            System.err.println("Severe: Invalid characters in input.");
            logger.severe("Severe: Invalid characters in input.");
        }
        return isValid;
    }

    /**
     * Validates an integer input.
     *
     * @param input The input integer.
     * @return True if valid, false otherwise.
     */
    public boolean validateInt(int input) {
        return input >= 0;
    }
}
