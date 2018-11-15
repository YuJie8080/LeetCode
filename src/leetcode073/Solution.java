package leetcode073;

/** <a>https://leetcode.com/problems/set-matrix-zeroes/</a>*/
public class Solution {
    
    public void setZeroes(int[][] matrix) {
        // Read matrix.
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        Point[] queue = new Point[m * n];
        int tail = 0;;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) queue[tail++] = new Point(i, j);
            }
        }
        // Read queue.
        for (int k = 0; k < tail; k++) {
            Point point = queue[k];
            for (int i = 0; i < m; i++) matrix[i][point.j] = 0;
            for (int j = 0; j < n; j++) matrix[point.i][j] = 0;
        }
    }

    private class Point {
        final int i;
        final int j;
        Point(int i, int j) {this.i = i; this.j = j; }
    }
    
}
