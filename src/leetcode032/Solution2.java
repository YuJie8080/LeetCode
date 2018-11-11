package leetcode032;

public class Solution2 {

    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        int start = 0, end = cs.length - 1;
        for (; start < cs.length && cs[start] == ')'; start++);
        for (; end >= 0 && cs[end] == '('; end--);
        int[] stack = new int[end - start + 2];
        int sp = 0;
        int bp = 0;
        for (int i = start; i <= end; i++) {
            if (cs[i] == '(') {
                stack[++sp] = -1;
                bp = sp;
            } else {
                if (bp > 0) {
                    int temp = 0;
                    for (; sp > 0 && stack[sp] > 0; sp--) temp += stack[sp];
                    stack[bp] = temp + 2;
                    for (; bp > 0 && stack[bp] > 0; bp--);
                    if (stack[bp] == -2) bp = 0;
                } else {
                    stack[++sp] = -2;
                    bp = 0;
                }
            }
        }
        int max = 0;
        int sum = 0;
        for (int i = 1; i <= sp; i++) {
            if (stack[i] > 0) {
                sum += stack[i];
            } else {
                max = sum > max ? sum : max;
                sum = 0;
            }
        }
        return sum > max ? sum : max;
    }
    
}
