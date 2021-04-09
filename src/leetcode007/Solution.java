package leetcode007;

/** <a>https://leetcode.com/problems/reverse-integer/</a> */
public class Solution {

    public int reverse(int x) {
        boolean sign = false;
        if (x < 0) {
            sign = true;
            x = 0 - x;
        }

        long result = 0;
        while (x > 0) {
            int mod = x % 10;
            result = result * 10 + mod;
            x = x / 10;
        }
        if (sign) {
            result = 0 - result;
        }
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int) result;
    }

}
