package leetcode091;

/**
 * Time Limit Exceeded<br>
 * input: "111111111111111111111111111111111111111111111"
 *
 */
public class Solution2 {

    public int numDecodings(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        return decodingCount(s);
    }

    private int decodingCount(String s) {
        if (s.length() > 0 && s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() < 2) {
            return 1;
        }
        int sum = 0;
        sum += decodingCount(s.substring(1));
        if (Integer.valueOf(s.substring(0, 2)) <= 26) {
            sum += decodingCount(s.substring(2));
        }
        return sum;
    }

}
