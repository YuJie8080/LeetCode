package leetcode064;

/** <a>https://leetcode.com/problems/minimum-path-sum/</a>*/
public class Solution {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        int[][] t = new int[m][n];
        t[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int i = m - 2; i >= 0; i--) {
            t[i][n - 1] = grid[i][n - 1] + t[i + 1][n - 1];
        }
        for (int j = n - 2; j >= 0; j--) {
            t[m - 1][j] = grid[m - 1][j] + t[m - 1][j + 1];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                t[i][j] = Math.min(t[i + 1][j], t[i][j + 1]) + grid[i][j];
            }
        }
        return t[0][0];
    }
    
}
