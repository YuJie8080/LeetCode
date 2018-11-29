package leetcode079;

public class Main {
    
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(s.exist(board, "ABAB"));
    }
    
}
