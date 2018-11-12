package leetcode060;

public class Solution {

    public String getPermutation(int n, int k) {
        int[] record = new int[n];
        int m = 1;
        for (int i = 1; i < n; i++) {
            m *= i;
            record[i] = m;
        }
        int[] numPool = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            numPool[i] = i;
        }
        k--;
        StringBuffer buffer = new StringBuffer();
        for (int i = record.length - 1; i > 0; i--) {
            int t = getIndex(numPool, k / record[i]);
            buffer.append(numPool[t]);
            k %= record[i];
            numPool[t] = 0;
        }
        buffer.append(numPool[getIndex(numPool, 0)]);
        return buffer.toString();
    }
    
    private int getIndex(int[] numPool, int k) {
        int i = 0, j = 0;
        for (; numPool[i] == 0; i++);
        for (; j < k; i++) {
            if (numPool[i] > 0) j++;
        }
        if (numPool[i] == 0) {
            for (; numPool[i] == 0; i++);
        }
        return i;
    }
    
}
