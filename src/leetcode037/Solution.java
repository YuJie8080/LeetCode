package leetcode037;

public class Solution {

    public void solveSudoku(char[][] board) {
        boolean[][] rowCheck = new boolean[9][9];
        boolean[][] columnCheck = new boolean[9][9];
        boolean[][][] boxCheck = new boolean[3][3][9];
        // init
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                use(i, j, board[i][j], board, rowCheck, columnCheck, boxCheck);
            }
        }
        solve(0, 0, board, rowCheck, columnCheck, boxCheck);
    }

    private boolean solve(int i, int j, char[][] board, boolean[][] rowCheck, boolean[][] columnCheck,
            boolean[][][] boxCheck) {
        if (i == 9) {
            return true;
        }
        if (j == 9) {
            if (solve(i + 1, 0, board, rowCheck, columnCheck, boxCheck)) {
                return true;
            }
        }
        for (;j < 9; j++) {
            if (board[i][j] != '.') {
                continue;
            }
            for (int k = 0; k < 9; k++) {
                char value = (char) (k + '1');
                if (!use(i, j, value, board, rowCheck, columnCheck, boxCheck)) {
                    continue;
                }
                if (solve(i, j + 1, board, rowCheck, columnCheck, boxCheck)) {
                    return true;
                }
                cancel(i, j, value, board, rowCheck, columnCheck, boxCheck);
            }
            // can't find any num
            return false;
        }
        return solve(i + 1, 0, board, rowCheck, columnCheck, boxCheck);
    }

    private boolean use(int i, int j, char value, char[][] board, boolean[][] rowCheck, boolean[][] columnCheck,
            boolean[][][] boxCheck) {
        int index = value - '1';
        if (!rowCheck[i][index] && !columnCheck[j][index] && !boxCheck[i / 3][j / 3][index]) {
            rowCheck[i][index] = true;
            columnCheck[j][index] = true;
            boxCheck[i / 3][j / 3][index] = true;
            board[i][j] = value;
            return true;
        }
        return false;
    }

    private void cancel(int i, int j, char value, char[][] board, boolean[][] rowCheck, boolean[][] columnCheck,
            boolean[][][] boxCheck) {
        int index = value - '1';
        rowCheck[i][index] = false;
        columnCheck[j][index] = false;
        boxCheck[i / 3][j / 3][index] = false;
        board[i][j] = '.';
    }

}
