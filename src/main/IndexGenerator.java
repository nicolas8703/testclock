package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generates an index of terms occurring more than three times.
 */
public class IndexGenerator {
    /**
     * Generates and prints the index.
     *
     * @param paragraphs The list of paragraphs.
     */
    public void generateIndex(List<String> paragraphs) {
        Map<String, List<Integer>> termOccurrences = new HashMap<>();
        int paragraphNumber = 1;
        for (String paragraph : paragraphs) {
            String[] words = paragraph.split("\\W+");
            for (String word : words) {
                if (Character.isUpperCase(word.codePointAt(0))) {
                    termOccurrences.computeIfAbsent(word, k -> new ArrayList<>()).add(paragraphNumber);
                }
            }
            paragraphNumber++;
        }
        for (Map.Entry<String, List<Integer>> entry : termOccurrences.entrySet()) {
            if (entry.getValue().size() > 3) {
                System.out.println(entry.getKey() + " " + entry.getValue().toString().replaceAll("[\\[\\]]", ""));
            }
        }
    }
}