package main.formatter;

import main.paragraph.Paragraph;

import java.util.List;

/**
 * Implements raw formatting of paragraphs.
 */
public class RawFormatter implements Formatter {

    @Override
    public String format(List<Paragraph> paragraphs) {
        StringBuilder sb = new StringBuilder();
        int index = 1;
        for (Paragraph paragraph : paragraphs) {
            sb.append(index).append(": ").append(paragraph.getText()).append("\n");
            index++;
        }
        return sb.toString();
    }
}
