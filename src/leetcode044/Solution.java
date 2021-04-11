package leetcode044;

// 未完成
@Deprecated
public class Solution {

    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        } else if ("".equals(s) && "".equals(p)) {
            return true;
        } else if (p == null || "".equals(p)) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        int si = 0;
        int pi = 0;
        while (si < sc.length && pi < pc.length) {
            if (pc[pi] == '*') {

            } else if (pc[pi] == '?') {

            } else {

            }
        }
        return false;
    }

}
