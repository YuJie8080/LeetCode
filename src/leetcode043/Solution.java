package leetcode043;

public class Solution {
    
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        char[] c1 = num1.toCharArray();
        int[][] pre = new int[10][c1.length];
        for (int i = 1; i < pre.length; i++) {
            for (int j = 0; j < c1.length; j++) {
                pre[i][j] = (c1[j] - '0') * i;
            }
        }
        char[] c2 = num2.toCharArray();
        int[] result = new int[c1.length + c2.length];
        for (int i = 0; i < c2.length; i++) {
            for (int j = 0; j < c1.length; j++) {
                result[i + j + 1] += pre[c2[i] - '0'][j];
            }
        }
        char[] c3 = new char[result.length];
        for (int i = result.length - 1; i > 0; i--) {
            result[i - 1] += (result[i] / 10);
            result[i] %= 10;
            c3[i] = (char) (result[i] + '0');
        }
        c3[0] = (char) (result[0] + '0');
        String str = new String(c3);
        if (c3[0] == '0') {
            return str.substring(1);
        } else {
            return str;
        }
    }

}
