package leetcode093;

import java.util.ArrayList;
import java.util.List;

/** <a>https://leetcode.com/problems/restore-ip-addresses/</a> */
public class Solution {

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 && s.length() > 12) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        dfs(s.toCharArray(), 0, 0, new int[4], result);
        return result;
    }

    private void dfs(char[] c, int index, int num, int[] ip, List<String> result) {
        if (index == c.length && num == 4) {
            result.add(new StringBuilder().append(ip[0]).append('.').append(ip[1]).append('.').append(ip[2]).append('.')
                    .append(ip[3]).toString());
        } else if (num < 4) {
            int temp = 0;
            for (int i = 0; i < 3 && index + i < c.length; i++) {
                temp = temp * 10 + (c[index + i] - '0');
                if (temp < 256) {
                    ip[num] = temp;
                    dfs(c, index + i + 1, num + 1, ip, result);
                    if (temp == 0) {
                        break;
                    }
                }
            }
        }
    }

}
