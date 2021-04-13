package leetcode030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }
        HashMap<String, Integer> wordCount = new HashMap<>(words.length);
        int n = words[0].length();
        for (int i = 0; i < words.length; i++) {
            wordCount.put(words[i], wordCount.getOrDefault(words[i], 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        HashMap<String, Integer> tempCount = new HashMap<>(wordCount);
        char[] c = s.toCharArray();
        int index = 0;
        for (int i = 0; i + n <= c.length; i += n) {
            String ts = new String(c, i, n);
            if (!tempCount.containsKey(ts)) {
                continue;
            }
            int count = tempCount.get(ts);
            if (count == 0) {
                boolean success = true;
                for (Entry<String, Integer> item : tempCount.entrySet()) {
                    if (item.getValue() > 0) {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    result.add(index);
                }
                index = i;
                tempCount = new HashMap<>(wordCount);
                tempCount.put(ts, tempCount.get(ts) - 1);
            } else {
                tempCount.put(ts, count - 1);
            }
        }
        return result;
    }

}
