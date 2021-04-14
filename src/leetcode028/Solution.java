package leetcode028;

public class Solution {

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();
        for (int i = 0; i + nee.length <= hay.length; i++) {
            int j = 0;
            for (; j < nee.length; j++) {
                if (hay[i + j] != nee[j]) {
                    break;
                }
            }
            if (j == nee.length) {
                return i;
            }
        }
        return -1;
    }

}
