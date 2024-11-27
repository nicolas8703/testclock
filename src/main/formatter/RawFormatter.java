package main.formatter;

import java.util.List;

/**
 * Formats paragraphs in raw format with paragraph numbers.
 */
public class RawFormatter implements Formatter {
    /**
     * Formats the paragraphs.
     *
     * @param paragraphs The paragraphs to format.
     * @return The formatted string.
     */
    @Override
    public String format(List<String> paragraphs) {
        StringBuilder output = new StringBuilder();
        int index = 1;
        for (String paragraph : paragraphs) {
            output.append(index).append(": ").append(paragraph).append("\n");
            index++;
        }
        return output.toString();
    }
}