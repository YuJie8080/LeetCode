package leetcode036;

public class Solution {
    
    private static final int LEN = 3;

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            if (!row(board, i)) return false;
        }
        for (int i = 0; i < board.length; i++) {
            if (!col(board, i)) return false;
        }
        for (int i = 0; i * 3 < board.length; i++) {
            for (int j = 0; j * 3 < board.length; j++) {
                if (!block(board, i * 3, j * 3)) return false;
            }
        }
        return true;
    }
    
    private boolean row(char[][] board, int x) {
        boolean[] nums = new boolean[board[x].length];
        for (int i = 0; i < board[x].length; i++) {
            if (board[x][i] == '.') continue;
            if (nums[board[x][i] - '1']) return false;
            nums[board[x][i] - '1'] = true;
        }
        return true;
    }
    
    private boolean col(char[][] board, int y) {
        boolean[] nums = new boolean[board.length];
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == '.') continue;
            if (nums[board[i][y] - '1']) return false;
            nums[board[i][y] - '1'] = true;
        }
        return true;
    }
    
    private boolean block(char[][] board, int x, int y) {
        boolean[] nums = new boolean[board.length];
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                if (board[x + i][y + j] == '.') continue;
                if (nums[board[x + i][y + j] - '1']) return false;
                nums[board[x + i][y + j] - '1'] = true;
            }
        }
        return true;
    }
    
}
