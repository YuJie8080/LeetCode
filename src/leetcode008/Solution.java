package leetcode008;

/** <a>https://leetcode.com/problems/reverse-integer/</a> */
public class Solution {

    public int myAtoi(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        long result = 0;
        // ignore white space
        for (; i < c.length && c[i] == ' '; i++)
            ;
        // negative?
        boolean negative = false;
        if (i < c.length) {
            if (c[i] == '-') {
                negative = true;
                i++;
            } else if (c[i] == '+') {
                i++;
            }
        }
        for (; i < c.length; i++) {
            if (c[i] < '0' || c[i] > '9') {
                break;
            }
            result = result * 10 + (c[i] - '0');
            if (negative && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (!negative && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return (int) (negative ? -result : result);
    }

}
