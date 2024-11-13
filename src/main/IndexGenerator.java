package main;

import main.paragraph.Paragraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Generates the index of terms appearing in paragraphs.
 */
public class IndexGenerator {

    /**
     * Generates an index of terms that occur more than three times across all paragraphs.
     * A term starts with an uppercase letter.
     *
     * @param paragraphs the list of Paragraph objects
     * @return a map of terms to a list of paragraph numbers
     */
    public Map<String, List<Integer>> generateIndex(List<Paragraph> paragraphs) {
        Map<String, Integer> termCounts = new HashMap<>(); // Total occurrence counts
        Map<String, Set<Integer>> termParagraphs = new HashMap<>(); // Paragraph numbers for each term

        int paragraphNumber = 1;

        for (Paragraph paragraph : paragraphs) {
            String[] words = paragraph.getText().split("\\s+");
            Set<String> termsInParagraph = new HashSet<>();

            for (String word : words) {
                // Remove punctuation and special characters
                word = word.replaceAll("[^a-zA-ZäöüÄÖÜ0-9]", "");
                if (!word.isEmpty() && Character.isUpperCase(word.charAt(0))) {
                    // Increment total count
                    termCounts.put(word, termCounts.getOrDefault(word, 0) + 1);

                    // Add paragraph number if term is present in this paragraph
                    termsInParagraph.add(word);
                }
            }

            // Map terms to paragraph numbers
            for (String term : termsInParagraph) {
                termParagraphs.computeIfAbsent(term, k -> new HashSet<>()).add(paragraphNumber);
            }

            paragraphNumber++;
        }

        // Filter terms that occur more than three times
        Map<String, List<Integer>> index = new HashMap<>();
        for (Map.Entry<String, Integer> entry : termCounts.entrySet()) {
            if (entry.getValue() > 3) {
                String term = entry.getKey();
                List<Integer> paragraphsList = new ArrayList<>(termParagraphs.get(term));
                index.put(term, paragraphsList);
            }
        }

        return index;
    }
}
