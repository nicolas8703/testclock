package main.commands;

import main.IndexGenerator;
import main.paragraph.ParagraphManager;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Collections;

/**
 * Generates and displays the index of terms.
 */
public class IndexCommand implements Command {
    private ParagraphManager paragraphManager;
    private IndexGenerator indexGenerator;

    /**
     * Initializes the IndexCommand.
     *
     * @param paragraphManager the ParagraphManager instance
     */
    public IndexCommand(ParagraphManager paragraphManager) {
        this.paragraphManager = paragraphManager;
        this.indexGenerator = new IndexGenerator();
    }

    @Override
    public void execute() {
        Map<String, List<Integer>> index = indexGenerator.generateIndex(paragraphManager.getAllParagraphs());
        for (Map.Entry<String, List<Integer>> entry : index.entrySet()) {
            String term = entry.getKey();
            List<Integer> paragraphNumbers = entry.getValue();
            // Sort the paragraph numbers
            Collections.sort(paragraphNumbers);
            String positions = paragraphNumbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            System.out.println(term + " " + positions);
        }
    }
}
