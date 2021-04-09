package leetcode005;

public class Solution {

    public String longestPalindrome(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            String str1 = middleSearch(s, i, i);
            if (str1.length() > result.length())
                result = str1;
            String str2 = middleSearch(s, i, i + 1);
            if (str2.length() > result.length())
                result = str2;
        }

        return result;
    }

    public String middleSearch(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        try {
            return s.substring(l + 1, r);
        } catch (Exception e) {
            return "";
        }
    }

}
