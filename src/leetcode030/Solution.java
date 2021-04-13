package leetcode030;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }
        int n = words[0].length();
        if (n == 0) {
            return new ArrayList<>();
        } else if (n == 1) {
            return findSubchar(s, words);
        }
        HashSet<Integer> wordSet = new HashSet<>(words.length);
        long hashSum = 0;
        for (int i = 0; i < words.length; i++) {
            int hash = words[i].hashCode();
            wordSet.add(hash);
            hashSum += hash;
        }
        List<Integer> result = new ArrayList<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int[] hashCodes = new int[(c.length - i) / n];
            int lastNotContain = -1;
            for (int j = 0; j < hashCodes.length; j++) {
                hashCodes[j] = new String(c, j * n + i, n).hashCode();
                if (wordSet.contains(hashCodes[j])) {
                    continue;
                }
                hashCodes[j] = 0;
                if (j - lastNotContain > words.length) {
                    continue;
                }
                for (int k = lastNotContain; k < j; k++) {
                    if (k < 0 || hashCodes[k] == 0) {
                        continue;
                    }
                    hashCodes[k] = 0;
                }
                lastNotContain = j;
            }
            long[] sum = new long[hashCodes.length];
            for (int j = 0; j < hashCodes.length; j++) {
                if (j == 0) {
                    sum[j] = hashCodes[j];
                } else if (j < words.length) {
                    sum[j] = hashCodes[j] + sum[j - 1];
                } else {
                    sum[j] = hashCodes[j] + sum[j - 1] - hashCodes[j - words.length];
                }
                if (sum[j] == hashSum && j + 1 >= words.length) {
                    result.add((j - words.length + 1) * n + i);
                }
            }
        }
        return result;
    }

    private List<Integer> findSubchar(String s, String[] words) {
        char[] c = s.toCharArray();
        char[] w = new char[words.length];
        int[] count = new int[26];
        for (int i = 0; i < w.length; i++) {
            w[i] = words[i].charAt(0);
            count[w[i] - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
            count[c[i] - 'a']--;
            if (i >= w.length) {
                count[c[i - w.length] - 'a']++;
            }
            if (i + 1 >= w.length) {
                boolean success = true;
                for (int j = 0; j < count.length; j++) {
                    if (count[j] != 0) {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    result.add(i - w.length + 1);
                }
            }
        }
        return result;
    }

}
