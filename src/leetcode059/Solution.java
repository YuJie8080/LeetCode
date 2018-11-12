package leetcode059;

public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        for (int i = 0; i < n + 1 >> 1; i++) {
            circle(matrix, i, num);
            num += ((n - 2 * i) * (n - 2 * i) - (n - 2 * i - 2) * (n - 2 * i - 2));
        }
        return matrix;
    }
    
    private void circle(int[][] matrix, int p, int n) {
        //top
        for (int i = p; i < matrix[0].length - p; i++)
            matrix[p][i] = n++;
        //right
        for (int i = p + 1; i < matrix.length - p; i++)
            matrix[i][matrix[0].length - p - 1] = n++;
        //bottom
        for (int i = matrix[0].length - p - 2; i >= p; i--)
            matrix[matrix.length - p - 1][i] = n++;
        //left
        for (int i = matrix.length - p - 2; i > p; i--)
            matrix[i][p] = n++;
    }
    
}
