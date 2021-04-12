package leetcode009;

public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int[] num = new int[10];
        int c = 0;
        while (x > 0) {
            num[c] = x % 10;
            x /= 10;
            c++;
        }

        for (int i = 0; i < c / 2; i++) {
            if (num[c - 1 - i] != num[i]) {
                return false;
            }
        }

        return true;
    }

}
