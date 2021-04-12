package leetcode014;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        char[][] cs = new char[strs.length][];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = strs[i].toCharArray();
        }
        int i = 0;
        out: for (;; i++) {
            for (int j = 0; j < cs.length; j++) {
                if (cs[j].length <= i || cs[0][i] != cs[j][i]) {
                    break out;
                }
            }
        }
        return new String(cs[0], 0, i);
    }

}
