package leetcode072;

public class Solution {

    public int minDistance(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int[][] dp = new int[c1.length + 1][c2.length + 1];
        dp[0][0] = 0;
        for (int i = 0; i < c1.length; i++) {
            dp[i + 1][0] = i + 1;
        }
        for (int i = 0; i < c2.length; i++) {
            dp[0][i + 1] = i + 1;
        }
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {
                if (c1[i] == c2[j]) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int min = dp[i][j];
                    min = dp[i + 1][j] < min ? dp[i + 1][j] : min;
                    min = dp[i][j + 1] < min ? dp[i][j + 1] : min;
                    dp[i + 1][j + 1] = min + 1;
                }
            }
        }
        return dp[c1.length][c2.length];
    }

}
