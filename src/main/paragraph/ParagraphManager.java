package main.paragraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the list of paragraphs.
 */
public class ParagraphManager {
    private List<Paragraph> paragraphs;

    /**
     * Initializes the ParagraphManager.
     */
    public ParagraphManager() {
        paragraphs = new ArrayList<>();
    }

    /**
     * Adds a paragraph at the specified position.
     *
     * @param position  the position to insert at (1-based, -1 for end)
     * @param paragraph the Paragraph object to add
     */
    public void addParagraph(int position, Paragraph paragraph) {
        if (position == -1 || position > paragraphs.size()) {
            paragraphs.add(paragraph);
        } else if (position >= 1 && position <= paragraphs.size()) {
            paragraphs.add(position - 1, paragraph);
        } else {
            paragraphs.add(paragraph);
        }
    }

    /**
     * Deletes the paragraph at the specified position.
     *
     * @param position the position to delete (1-based, -1 for last)
     * @throws Exception if the position is invalid
     */
    public void deleteParagraph(int position) throws Exception {
        if (paragraphs.isEmpty()) {
            throw new Exception("No paragraphs to delete.");
        }
        if (position == -1) {
            paragraphs.remove(paragraphs.size() - 1);
        } else if (position >= 1 && position <= paragraphs.size()) {
            paragraphs.remove(position - 1);
        } else {
            throw new Exception("Invalid paragraph number.");
        }
    }

    /**
     * Retrieves the paragraph at the specified position.
     *
     * @param position the position to retrieve (1-based)
     * @return the Paragraph object
     * @throws Exception if the position is invalid
     */
    public Paragraph getParagraph(int position) throws Exception {
        if (position >= 1 && position <= paragraphs.size()) {
            return paragraphs.get(position - 1);
        } else {
            throw new Exception("Invalid paragraph number.");
        }
    }

    /**
     * Retrieves the last paragraph.
     *
     * @return the last Paragraph object
     * @throws Exception if there are no paragraphs
     */
    public Paragraph getLastParagraph() throws Exception {
        if (paragraphs.isEmpty()) {
            throw new Exception("No paragraphs available.");
        }
        return paragraphs.get(paragraphs.size() - 1);
    }

    /**
     * Retrieves all paragraphs.
     *
     * @return a list of Paragraph objects
     */
    public List<Paragraph> getAllParagraphs() {
        return paragraphs;
    }
}
