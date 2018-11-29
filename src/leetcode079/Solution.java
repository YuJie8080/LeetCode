package leetcode079;

/** <a>https://leetcode.com/problems/word-search/</a>*/
public class Solution {
    
    public boolean exist(char[][] board, String word) {
        if (word == null || word.equals("")) return true;
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (words[0] == board[i][j]) {
                    char temp = board[i][j];
                    board[i][j] = ' ';
                    if (match(board, i, j, words, 1)) return true;
                    board[i][j] = temp;
                }
            }
        }
        return false;
    }
    
    private boolean match(char[][] board, int i, int j, char[] words, int current) {
        if (current == words.length) return true;
        // up
        if (i > 0 && board[i - 1][j] == words[current]) {
            char temp = board[i - 1][j];
            board[i - 1][j] = ' ';
            if (match(board, i - 1, j, words, current + 1)) return true;
            board[i - 1][j] = temp;
        }
        // down
        if (i + 1 < board.length && board[i + 1][j] == words[current]) {
            char temp = board[i + 1][j];
            board[i + 1][j] = ' ';
            if (match(board, i + 1, j, words, current + 1)) return true;
            board[i + 1][j] = temp;
        }
        // left
        if (j > 0 && board[i][j - 1] == words[current]) {
            char temp = board[i][j - 1];
            board[i][j - 1] = ' ';
            if (match(board, i, j - 1, words, current + 1)) return true;
            board[i][j - 1] = temp;
        }
        // right
        if (j + 1 < board[i].length && board[i][j + 1] == words[current]) {
            char temp = board[i][j + 1];
            board[i][j + 1] = ' ';
            if (match(board, i, j + 1, words, current + 1)) return true;
            board[i][j + 1] = temp;
        }
        return false;
    }
    
}
