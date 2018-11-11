package leetcode051;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private void dfs(int n, int[] queen, boolean[] top, boolean[] bottom, List<List<String>> result) {
        if (n < queen.length) {
            for (int i = n; i < queen.length; i++) {
                int temp = queen[i];
                queen[i] = queen[n];
                queen[n] = temp;
                int topIndex = queen[n] + n;
                int bottomIndex = n + queen.length - 1 - queen[n];
                if (!top[topIndex] && !bottom[bottomIndex]) {
                    top[topIndex] = true;
                    bottom[bottomIndex] = true;
                    
                    dfs(n + 1, queen, top, bottom, result);
                    
                    top[topIndex] = false;
                    bottom[bottomIndex] = false;
                }
                temp = queen[i];
                queen[i] = queen[n];
                queen[n] = temp;
            }
        } else {
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < queen.length; i++) {
                char[] cs = new char[queen.length];
                for (int j = 0; j < cs.length; j++) {
                    cs[j] = j == queen[i] ? 'Q' : '.';
                }
                list.add(new String(cs));
            }
            result.add(list);
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        int[] queen = new int[n];
        for (int i = 0; i < n; i++)
            queen[i] = i;
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        dfs(0, queen, new boolean[n << 1], new boolean[n << 1], result);
        return result;
    }
    
}
