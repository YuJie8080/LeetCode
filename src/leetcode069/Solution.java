package leetcode069;

public class Solution {

    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        long start = 0;
        long end = x;
        while (start <= end) {
            long mid = (start + end) >> 1;
            long p = mid * mid;
            if (p == x) {
                return (int) mid;
            } else if (p > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (int) (start - 1);
    }

}
