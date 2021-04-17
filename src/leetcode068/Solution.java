package leetcode068;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<>();
        List<String> temp = new LinkedList<>();
        int count = 0;
        int totalWidth = 0;
        for (int i = 0; i < words.length; i++) {
            int wordWidth = words[i].length();
            int currentWidth = totalWidth + wordWidth + (count > 0 ? count - 1 : 0);
            if (currentWidth >= maxWidth && count > 0) {
                String line = toLine(temp, maxWidth, totalWidth, count, true);
                result.add(line);
                temp.clear();
                count = 0;
                totalWidth = 0;
            }
            temp.add(words[i]);
            count++;
            totalWidth += wordWidth;
        }
        String line = toLine(temp, maxWidth, totalWidth, count, false);
        result.add(line);
        return result;
    }

    private String toLine(List<String> words, int maxWidth, int totalWidth, int count, boolean fullyJustified) {
        if (count == 1 || !fullyJustified) {
            StringBuilder line = new StringBuilder();
            int j = 0;
            for (String word : words) {
                if (j != 0) {
                    line.append(' ');
                    totalWidth++;
                }
                line.append(word);
                j++;
            }
            for (int i = totalWidth; i < maxWidth; i++) {
                line.append(' ');
            }
            return line.toString();
        }
        int spaceWidth = (maxWidth - totalWidth) / (count - 1);
        int needAddSpaceCount = (maxWidth - totalWidth) % (count - 1);
        StringBuilder baseSpace = new StringBuilder();
        for (int j = 0; j < spaceWidth; j++) {
            baseSpace.append(' ');
        }
        StringBuilder line = new StringBuilder();
        int j = 0;
        for (String word : words) {
            line.append(word);
            if (j == count - 1) {
                break;
            }
            line.append(baseSpace);
            if (j < needAddSpaceCount) {
                line.append(' ');
            }
            j++;
        }
        return line.toString();
    }

}
