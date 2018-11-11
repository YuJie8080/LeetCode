package leetcode048;

public class Solution2 {

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int t = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = t;
    }
    
    private void reverse(int[][] matrix, int line) {
        for (int i = 0; i < matrix[line].length >> 1; i++) {
            swap(matrix, line, i, line, matrix[line].length - 1 - i);
        }
    }
    
    private void diaSym(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - i; j++) {
                swap(matrix, i, j, matrix[i].length - 1 - j, matrix.length - 1 - i);
            }
        }
    }
    
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            reverse(matrix, i);
        }
        diaSym(matrix);
    }
    
}
