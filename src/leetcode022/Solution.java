package leetcode022;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (n == 0) return result;
        char[] c = init(n);
        dfs(c, 0, result);
        return result;
    }
    
    private char[] init(int n) {
        char[] c = new char[n << 1];
        for (int i = 0; i < c.length; i++) {
            c[i] = i % 2 == 0 ? '(' : ')';
        }
        return c;
    }
    
    private void dfs(char[] c, int n, ArrayList<String> result) {
        result.add(new String(c));
        for (int i = n; i < c.length; i++) {
            if (c[i] == '(') continue;
            int j = i + 1;
            for (; j < c.length && c[j] == ')'; j++);
            if (j < c.length) {
                swap(c, i, j);
                dfs(c, i, result);
                swap(c, i, j);
            }
        }
    }
    
    private void swap(char[] cs, int a, int b) {
        char c = cs[a];
        cs[a] = cs[b];
        cs[b] = c;
    }
    
}
