package leetcode050;

public class Solution {

    public double myPow(double x, int n) {
        long ln = n;
        return myPow(x, ln);
    }

    private double myPow(double x, long n) {
        if (n == 0) {
            return 1;
        } else if (x == 0) {
            return 0;
        } else if (n < 0) {
            return 1.0 / myPow(x, -n);
        }
        long tn = n;
        int tc = 0;
        long tp = 1;
        while (tn > 0) {
            tn >>= 1;
            tc++;
            tp <<= 1;
        }
        tp >>= 1;
        double[] record = new double[tc + 1];
        record[0] = 1;
        record[1] = x;
        for (int i = 2; i < record.length; i++) {
            record[i] = record[i - 1] * record[i - 1];
        }
        double result = 1;
        while (n > 0 && tc > 0) {
            if (tp > n) {
                tp >>= 1;
                tc--;
            } else {
                result *= record[tc];
                n -= tp;
            }
        }
        return result;
    }

}
