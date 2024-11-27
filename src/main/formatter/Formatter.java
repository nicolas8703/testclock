package main.formatter;

import java.util.List;


/**
 * An interface for formatting paragraphs.
 */
public interface Formatter {
    /**
     * Formats a list of paragraphs.
     *
     * @param paragraphs The paragraphs to format.
     * @return The formatted string.
     */
    String format(List<String> paragraphs);
}