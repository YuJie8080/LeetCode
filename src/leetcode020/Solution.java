package leetcode020;

public class Solution {

    public boolean isValid(String s) {
        char[] str = s.toCharArray();
        int p = -1;
        char[] stack = new char[str.length];
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ')' || str[i] == '}' || str[i] == ']') {
                // right part
                if (p < 0 || !(stack[p] < str[i] && stack[p] >= str[i] - 2)) {
                    return false;
                }
                p--;
            } else {
                // left part
                stack[++p] = str[i];
            }
        }
        return p == -1;
    }

}
