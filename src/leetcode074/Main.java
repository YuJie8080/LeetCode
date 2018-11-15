package leetcode074;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7},{10, 11, 16, 20}, {23, 30, 34, 50}};
        Solution s = new Solution();
        for (int i = 0; i < 55; i++) {
            System.out.print(i + ":");
            System.out.println(s.searchMatrix(matrix, i));
        }
    }

}
