package leetcode030;

import java.util.List;

import common.ShowDetail;

public class Main {

    public static void main(String[] args) {
        String str = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        Solution s = new Solution();
        List<Integer> list = s.findSubstring(str, words);
        ShowDetail.list(list);
    }

}
