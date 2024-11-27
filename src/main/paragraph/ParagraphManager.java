package main.paragraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the paragraphs in the text editor.
 */
public class ParagraphManager {
    private List<String> paragraphs;

    /**
     * Constructs a ParagraphManager.
     */
    public ParagraphManager() {
        this.paragraphs = new ArrayList<>();
    }

    /**
     * Adds a paragraph at the specified position.
     *
     * @param position  The position to insert at.
     * @param paragraph The paragraph text.
     */
    public void addParagraph(int position, String paragraph) {
        if (position >= 0 && position <= paragraphs.size()) {
            paragraphs.add(position, paragraph);
        } else {
            paragraphs.add(paragraph);
        }
    }

    /**
     * Deletes the paragraph at the specified position.
     *
     * @param position The position of the paragraph to delete.
     */
    public void deleteParagraph(int position) {
        if (position >= 0 && position < paragraphs.size()) {
            paragraphs.remove(position);
        }
    }

    /**
     * Gets the paragraph at the specified position.
     *
     * @param position The position of the paragraph.
     * @return The paragraph text.
     */
    public String getParagraph(int position) {
        if (position >= 0 && position < paragraphs.size()) {
            return paragraphs.get(position);
        }
        return null;
    }

    /**
     * Gets the last paragraph.
     *
     * @return The last paragraph text.
     */
    public String getLastParagraph() {
        if (!paragraphs.isEmpty()) {
            return paragraphs.get(paragraphs.size() - 1);
        }
        return null;
    }

    /**
     * Gets all paragraphs.
     *
     * @return A list of paragraphs.
     */
    public List<String> getParagraphs() {
        return paragraphs;
    }
}
