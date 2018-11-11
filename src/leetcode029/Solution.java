package leetcode029;

public class Solution {
    
    public int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        if (divisor == -1) return -dividend;
        if (divisor > 0) {
            if (dividend < 0) return -divideNegative(dividend, -divisor);
            else return divideNegative(-dividend, -divisor);
        } else {
            if (dividend < 0) return divideNegative(dividend, divisor);
            else return -divideNegative(-dividend, divisor);
        }
    }
    
    private int divideNegative(int dividend, int divisor) {
        if (dividend > divisor) return 0;
        int[] mul = new int[32];
        mul[1] = divisor;
        int p = 2;
        for (; p < mul.length && mul[p - 1] >= dividend && mul[p - 1] >= (Integer.MIN_VALUE >> 1); p++) {
            mul[p] = mul[p - 1] + mul[p - 1];
        }
        p--;
        int result = 0;
        while (dividend <= divisor) {
            if (dividend <= mul[p]) {
                result += (1 << p - 1);
                dividend -= mul[p];
            }
            p--;
        }
        return result;
    }
    
}
