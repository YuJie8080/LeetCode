package leetcode058;

public class Solution {

    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        char[] c = s.toCharArray();
        int len = 0;
        int i = c.length - 1;
        for (; i >= 0 && c[i] == ' '; i--)
            ;
        for (; i >= 0; i--) {
            if (c[i] == ' ') {
                break;
            }
            len++;
        }
        return len;
    }

}
