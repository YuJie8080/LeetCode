package leetcode090;

import java.util.List;

import common.ShowDetail;

public class Main {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2 };
        Solution s = new Solution();
        List<List<Integer>> result = s.subsetsWithDup(nums);
        for (List<Integer> list : result) {
            ShowDetail.list(list);
        }
    }

}
