package leetcode003;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        String str, register = "";

        for (int i = 0; i < s.length(); i++) {
            str = s.charAt(i) + "";
            if (register.indexOf(str) != -1) {
                if (register.length() > max)
                    max = register.length();

                register = register.substring(register.indexOf(str) + 1);
            }
            register += str;
        }
        if (register.length() > max)
            max = register.length();

        return max;
    }

}
