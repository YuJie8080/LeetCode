package leetcode038;

/** <a>https://leetcode.com/problems/count-and-say/</a> */
public class Solution {

    public String countAndSay(int n) {
        String[] result = new String[n];
        result[0] = "1";
        for (int i = 1; i < n; i++) {
            result[i] = say(result[i - 1]);
        }
        return result[n - 1];
    }

    private String say(String str) {
        char[] c = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        char current = c[0];
        int count = 1;
        for (int i = 1; i < c.length; i++) {
            if (c[i] == current) {
                count++;
            } else {
                builder.append(count).append(current);
                current = c[i];
                count = 1;
            }
        }
        builder.append(count).append(current);
        return builder.toString();
    }

}
