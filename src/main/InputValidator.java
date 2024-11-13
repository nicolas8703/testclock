package main;

/**
 * Validates and filters user input.
 */
public class InputValidator {

    /**
     * Validates the input string by filtering out unwanted characters.
     *
     * @param input the input string
     * @return the validated and filtered string
     */
    public String validate(String input) {
        String allowedChars = "[^a-zA-ZäöüÄÖÜ0-9 .,:;\\-!? '()\"%@+*\\[\\]{}/\\\\&#$]";
        return input.replaceAll(allowedChars, "");
    }
}
