package leetcode032;

public class Solution {

    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        int[] bs = new int[cs.length + 1];
        int[] mp = new int[bs.length];
        int p = 0;
        int max = 0;
        int start = 0, end = cs.length - 1;
        for (; start < cs.length && cs[start] == ')'; start++);
        for (; end >= 0 && cs[end] == '('; end--);
        for (int i = start; i <= end; i++) {
            char c = cs[i];
            if (c == '(') {
                if (mp[p] == 0) bs[p]++;
                else bs[++p]++;
            } else {
                bs[p]--;
                if (bs[p] > 0) {
                    mp[p]++;
                    max = mp[p] > max ? mp[p] : max;
                } else if (bs[p] == 0) {
                    mp[p]++;
                    if (p > 0 && bs[p - 1] >= 0) {
                        p--;
                        mp[p] += mp[p + 1];
                        mp[p + 1] = 0;
                        bs[p + 1] = 0;
                    }
                    max = mp[p] > max ? mp[p] : max;
                } else {
                    int q = p - 1;
                    for (; q > 0 && bs[q] >= 0; q--);
                    if (q > 0 && bs[q] > 0) {
                        bs[q]--;
                        mp[q] += (mp[p] + 1);
                        max = mp[q] > max ? mp[q] : max;
                    }
                }
            }
        }
        return max << 1;
    }
    
}
