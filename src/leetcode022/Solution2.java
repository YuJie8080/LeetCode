package leetcode022;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        int len = n << 1;
        int all = 1 << len;
        for (int i = 0; i < all; i++) {
            String t = judge(i, len);
            if (t != null) result.add(t);
        }
        return result;
    }
    
    private String judge(int num, int len) {
        int judge = 0;
        char[] c = new char[len];
        for (int i = 0; i < len; i++) {
            int mod = num % 2;
            if (mod == 0) judge--;
            else judge++;
            c[len - i - 1] = (char) (40 + mod);
            num >>= 1;
            if (judge < 0) return null;
        }
        if (judge != 0) return null;
        return new String(c);
    }
    
}
