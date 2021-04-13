package leetcode030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution2 {

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }
        HashMap<Integer, Integer> wordCount = new HashMap<>(words.length);
        int n = words[0].length();
        for (int i = 0; i < words.length; i++) {
            int hash = words[i].hashCode();
            wordCount.put(hash, wordCount.getOrDefault(hash, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int[] hashCodes = new int[(c.length - i) / n];
            for (int j = 0; j < hashCodes.length; j++) {
                hashCodes[j] = new String(c, j * n + i, n).hashCode();
            }
            for (int j = 0; j <= hashCodes.length - words.length; j++) {
                HashMap<Integer, Integer> tempCount = new HashMap<>(wordCount);
                boolean success = true;
                for (int k = 0; k < words.length; k++) {
                    int hash = hashCodes[j + k];
                    if (!tempCount.containsKey(hash)) {
                        tempCount = new HashMap<>(wordCount);
                        success = false;
                        break;
                    }
                    int count = tempCount.get(hash);
                    if (count == 0) {
                        tempCount = new HashMap<>(wordCount);
                        success = false;
                        break;
                    }
                    tempCount.put(hash, count - 1);
                }
                if (success) {
                    result.add(j * n + i);
                }
            }
        }
        return result;
    }

}
