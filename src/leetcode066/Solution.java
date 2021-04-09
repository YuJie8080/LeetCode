package leetcode066;

/** <a>https://leetcode.com/problems/plus-one/</a> */
public class Solution {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        boolean needOneMoreBit = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 > 9) {
                if (i == 0) {
                    needOneMoreBit = true;
                } else {
                    digits[i] = 0;
                }
            } else {
                digits[i] = digits[i] + 1;
                break;
            }
        }
        if (!needOneMoreBit) {
            return digits;
        }
        int[] result = new int[digits.length + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i == 0 ? 1 : 0;
        }
        return result;
    }

}
