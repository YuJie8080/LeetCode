package leetcode006;

public class Solution {

    public String convert(String s, int numRows) {
        if (numRows < 2)
            return s;

        String[] part = new String[numRows];
        int circle = (numRows - 1) * 2;

        for (int i = 0; i < numRows; i++) {
            part[i] = "";
        }

        for (int i = 0; i < s.length(); i++) {
            part[Math.abs(circle / 2 - i % circle)] += s.charAt(i);
        }

        String result = "";

        for (int i = numRows - 1; i >= 0; i--) {
            result += part[i];
        }

        return result;
    }

}
