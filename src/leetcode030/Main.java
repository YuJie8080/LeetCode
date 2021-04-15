package leetcode030;

import java.util.List;

import common.Output;

public class Main {

    public static void main(String[] args) {
        String str = "bcabbcaabbccacacbabccacaababcbb";
        String[] words = { "c", "b", "a", "c", "a", "a", "a", "b", "c" };
        Solution s = new Solution();
        List<Integer> list = s.findSubstring(str, words);
        Output.list(list);
    }

}
