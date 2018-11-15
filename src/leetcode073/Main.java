package leetcode073;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0}, {3,4,5,2},{1,3,1,5}};
        Solution s = new Solution();
        s.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
