package leetcode013;

public class Solution {

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        char[] c = s.toCharArray();
        boolean lastI = false;
        boolean lastX = false;
        boolean lastC = false;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'M') {
                result += 1000;
                if (lastC) {
                    result -= 200;
                    lastC = false;
                }
            } else if (c[i] == 'D') {
                result += 500;
                if (lastC) {
                    result -= 200;
                    lastC = false;
                }
            } else if (c[i] == 'C') {
                result += 100;
                lastC = true;
                if (lastX) {
                    result -= 20;
                    lastX = false;
                }
            } else if (c[i] == 'L') {
                result += 50;
                if (lastX) {
                    result -= 20;
                    lastX = false;
                }
            } else if (c[i] == 'X') {
                result += 10;
                lastX = true;
                if (lastI) {
                    result -= 2;
                    lastI = false;
                }
            } else if (c[i] == 'V') {
                result += 5;
                if (lastI) {
                    result -= 2;
                    lastI = false;
                }
            } else {
                result += 1;
                lastI = true;
            }
        }
        return result;
    }

}
