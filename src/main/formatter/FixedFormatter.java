package main.formatter;
import main.paragraph.Paragraph;

import java.util.List;

public class FixedFormatter implements Formatter {
    private int columnWidth;

    public FixedFormatter(int columnWidth) {
        this.columnWidth = columnWidth;
    }

    @Override
    public String format(List<Paragraph> paragraphs) {
        StringBuilder sb = new StringBuilder();

        for (Paragraph paragraph : paragraphs) {
            String text = paragraph.getText();
            int index = 0;
            int textLength = text.length();

            while (index < textLength) {
                int endIndex = Math.min(index + columnWidth, textLength);
                int spaceIndex = -1;

                // Suche nach dem letzten Leerzeichen im Bereich
                spaceIndex = text.lastIndexOf(' ', endIndex - 1);

                // Wenn kein Leerzeichen gefunden wurde oder das Leerzeichen vor dem aktuellen Index liegt
                if (spaceIndex < index) {
                    spaceIndex = -1;
                }

                if (spaceIndex != -1) {
                    // Das Leerzeichen wird noch auf die aktuelle Zeile gesetzt
                    String line = text.substring(index, spaceIndex + 1);
                    sb.append(line).append("\n");
                    index = spaceIndex + 1;
                } else {
                    // Behandlung von langen Wörtern oder wenn kein Leerzeichen gefunden wurde
                    String line = text.substring(index, endIndex);
                    sb.append(line).append("\n");
                    index = endIndex;
                }

                // Sicherheitsüberprüfung, um Endlosschleifen zu vermeiden
                if (endIndex == index) {
                    // Inkrementieren, um Fortschritt zu gewährleisten
                    index++;
                }
            }
        }

        return sb.toString();
    }
}

