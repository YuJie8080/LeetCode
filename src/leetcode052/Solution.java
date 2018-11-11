package leetcode052;

public class Solution {
    
    private int num = 0;

    private void dfs(int n, int[] queen, boolean[] top, boolean[] bottom) {
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
                    
                    dfs(n + 1, queen, top, bottom);
                    
                    top[topIndex] = false;
                    bottom[bottomIndex] = false;
                }
                temp = queen[i];
                queen[i] = queen[n];
                queen[n] = temp;
            }
        } else {
            num++;
        }
    }
    
    public int totalNQueens(int n) {
        int[] queen = new int[n];
        for (int i = 0; i < n; i++)
            queen[i] = i;
        num = 0;
        dfs(0, queen, new boolean[n << 1], new boolean[n << 1]);
        return num;
    }
    
}
