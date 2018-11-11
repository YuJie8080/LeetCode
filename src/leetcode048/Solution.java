package leetcode048;

public class Solution {

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length >> 1; i++) {
            for (int j = i; j < matrix.length - 1 - i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = t;
            }
        }
    }
    
}
