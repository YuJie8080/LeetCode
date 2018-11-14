package leetcode063;

/** <a>https://leetcode.com/problems/unique-paths-ii/</a>*/
public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        if (n == 0) return 0;
        if (m == 1) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[0][j] == 1) return 0;
            }
            return 1;
        }
        if (n == 1) {
            for (int i = 0; i < obstacleGrid.length; i++) {
                if (obstacleGrid[i][0] == 1) return 0;
            }
            return 1;
        }
        if (obstacleGrid[m - 1][n - 1] == 1) return 0;
        int[][] t = new int[m][n];
        for (int i = m - 2; i >= 0 && obstacleGrid[i][n - 1] != 1; i--) t[i][n - 1] = 1;
        for (int j = n - 2; j >= 0 && obstacleGrid[m - 1][j] != 1; j--) t[m -1][j] = 1;
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    t[i][j] = 0;
                } else {
                    if (obstacleGrid[i + 1][j] != 1) t[i][j] += t[i + 1][j];
                    if (obstacleGrid[i][j + 1] != 1) t[i][j] += t[i][j + 1];
                }
            }
        }
        return t[0][0];
    }
    
}
