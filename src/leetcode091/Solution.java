package leetcode091;

/** <a>https://leetcode.com/problems/decode-ways/</a> */
public class Solution {

    private static final int[] FIBONACCI = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584,
            4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309,
            3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296,
            433494437, 701408733, 1134903170, 1836311903 };

    public int numDecodings(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] c = s.toCharArray();
        int count = 1;
        int stack = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '1' || c[i] == '2') {
                stack++;
            } else {
                if (c[i] == '0') {
                    if (stack == 0) {
                        return 0;
                    }
                    count *= FIBONACCI[stack - 1];
                } else if (c[i] > '6') {
                    // 27 28 29
                    if (stack > 0 && c[i - 1] == '2') {
                        count *= FIBONACCI[stack];
                    } else {
                        count *= FIBONACCI[stack + 1];
                    }
                } else {
                    count *= FIBONACCI[stack + 1];
                }
                stack = 0;
            }
        }
        if (stack > 0) {
            count *= FIBONACCI[stack];
        }
        return count;
    }

}
