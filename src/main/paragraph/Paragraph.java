package main.paragraph;


/**
 * Represents a single paragraph.
 */
public class Paragraph {
    private String text;

    /**
     * Initializes the Paragraph with text.
     *
     * @param text the paragraph text
     */
    public Paragraph(String text) {
        this.text = text;
    }

    /**
     * Sets the paragraph text.
     *
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Retrieves the paragraph text.
     *
     * @return the paragraph text
     */
    public String getText() {
        return text;
    }

    /**
     * Replaces occurrences of searchText with replaceText.
     *
     * @param searchText  the text to search for
     * @param replaceText the text to replace with
     */
    public void replaceText(String searchText, String replaceText) {
        text = text.replace(searchText, replaceText);
    }
}
