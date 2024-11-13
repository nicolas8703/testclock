package main.formatter;

import main.paragraph.Paragraph;

import java.util.List;

/**
 * Defines the interface for formatting text.
 */
public interface Formatter {

    /**
     * Formats a list of paragraphs.
     *
     * @param paragraphs the list of Paragraph objects
     * @return the formatted text
     */
    String format(List<Paragraph> paragraphs);
}
