package leetcode054;

import java.util.List;

public class Main {
    
    public static final int[][] generate(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = i * n + j + 1;
            }
        }
        return matrix;
    }

    public static final void show(List<Integer> result) {
        for (int i = 0; i < result.size(); i++)
            System.out.print(result.get(i) + ",");
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = generate(0,0);
        List<Integer> result = s.spiralOrder(matrix);
        show(result);
    }

}
