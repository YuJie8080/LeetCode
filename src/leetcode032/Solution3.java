package leetcode032;

public class Solution3 {

    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        int start = 0, end = cs.length - 1;
        for (; start < cs.length && cs[start] == ')'; start++);
        for (; end >= 0 && cs[end] == '('; end--);
        int[] result = new int[end - start + 1];
        int[] bs = new int[end - start + 2];
        int bc = 0;
        int bp = 0;
        for (int i = start; i <= end; i++) {
            if (cs[i] == '(') {
                result[i - start] = -1;
                bc++;
                bs[++bp] = i - start;
            } else {
                if (bc > 0) {
                    result[i - start] = 3;
                    bc--;
                    bp--;
                } else {
                    result[i - start] = Integer.MIN_VALUE;
                }
            }
        }
        for (int i = 1; i <= bp; i++) result[bs[i]] = Integer.MIN_VALUE;
        return getMax(result);
    }
    
    private int getMax(int[] arr) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == Integer.MIN_VALUE) {
                
                max = sum > max ? sum : max;
                sum = 0;
            } else {
                sum += arr[i];
            }
        }
        return sum > max ? sum : max;
    }
    
}
