package leetcode044;

public class Solution {

    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        } else if ("".equals(s) && "".equals(p)) {
            return true;
        } else if (p == null || "".equals(p)) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        boolean[][] dp = new boolean[sc.length + 1][pc.length + 1];
        dp[0][0] = true;
        for (int i = 0; i < pc.length; i++) {
            if (pc[i] == '*') {
                dp[0][i + 1] = dp[0][i];
            }
        }
        for (int i = 0; i < sc.length; i++) {
            for (int j = 0; j < pc.length; j++) {
                if (sc[i] == pc[j] || pc[j] == '?') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (pc[j] == '*') {
                    dp[i + 1][j + 1] = dp[i][j + 1] | dp[i + 1][j];
                } else {
                    dp[i + 1][j + 1] = false;
                }
            }
        }
        return dp[sc.length][pc.length];
    }

}
