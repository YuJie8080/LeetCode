package leetcode054;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    private void circle(int[][] matrix, int n, List<Integer> result) {
        //top
        for (int i = n; i < matrix[0].length - n; i++)
            result.add(matrix[n][i]);
        //right
        for (int i = n + 1; i < matrix.length - n; i++)
            result.add(matrix[i][matrix[0].length - n - 1]);
        //bottom
        if (result.size() >= matrix.length * matrix[0].length) return;
        for (int i = matrix[0].length - n - 2; i >= n; i--)
            result.add(matrix[matrix.length - n - 1][i]);
        //left
        for (int i = matrix.length - n - 2; i > n; i--)
            result.add(matrix[i][n]);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) return result;
        int min = matrix.length < matrix[0].length ? matrix.length : matrix[0].length;
        for (int i = 0; i < min + 1 >> 1; i++)
            circle(matrix, i, result);
        return result;
    }
    
}
