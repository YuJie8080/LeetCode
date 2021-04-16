package leetcode065;

public class Solution {

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] c = s.toCharArray();
        boolean dot = false;
        boolean num = false;
        boolean eNum = true;
        int i = 0;
        for (; i < c.length; i++) {
            if (c[i] == '+' || c[i] == '-') {
                if (i != 0) {
                    return false;
                }
            } else if (c[i] == '.') {
                if (!dot) {
                    dot = true;
                } else {
                    return false;
                }
            } else if (c[i] == 'e' || c[i] == 'E') {
                if (!num) {
                    return false;
                }
                i++;
                eNum = false;
                break;
            } else if (c[i] >= '0' && c[i] <= '9') {
                num = true;
            } else {
                return false;
            }
        }
        if (!num) {
            return false;
        }
        for (; i < c.length; i++) {
            if (c[i] == '+' || c[i] == '-') {
                if (c[i - 1] != 'e' && c[i - 1] != 'E') {
                    return false;
                }
            } else if (c[i] >= '0' && c[i] <= '9') {
                eNum = true;
            } else {
                return false;
            }
        }
        return num && eNum;
    }

}
