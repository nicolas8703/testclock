package main.formatter;

import java.util.List;

/**
 * Formats paragraphs with a fixed column width.
 */
public class FixedFormatter implements Formatter {
    private int columnWidth;

    /**
     * Constructs a FixedFormatter.
     *
     * @param columnWidth The maximum column width.
     */
    public FixedFormatter(int columnWidth) {
        this.columnWidth = columnWidth;
    }

    /**
     * Formats the paragraphs.
     *
     * @param paragraphs The paragraphs to format.
     * @return The formatted string.
     */
    @Override
    public String format(List<String> paragraphs) {
        StringBuilder output = new StringBuilder();
        for (String paragraph : paragraphs) {
            output.append(wrapText(paragraph)).append("\n");
        }
        return output.toString();
    }

    /**
     * Wraps text according to the specified column width.
     *
     * @param text The text to wrap.
     * @return The wrapped text.
     */
    private String wrapText(String text) {
        StringBuilder wrapped = new StringBuilder();
        String[] words = text.split(" ");
        int lineLength = 0;
        for (String word : words) {
            if (lineLength + word.length() <= columnWidth) {
                wrapped.append(word).append(" ");
                lineLength += word.length() + 1;
            } else {
                wrapped.append("\n").append(word).append(" ");
                lineLength = word.length() + 1;
            }
        }
        return wrapped.toString();
    }
}
