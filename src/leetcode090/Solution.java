package leetcode090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** <a>https://leetcode.com/problems/subsets-ii/</a> */
public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        Arrays.sort(nums);
        getResult(0, nums, result, new ArrayList<>());
        return result;
    }

    private void getResult(int n, int[] nums, List<List<Integer>> result, List<Integer> list) {
        result.add(new ArrayList<>(list));
        Integer last = null;
        for (int i = n; i < nums.length; i++) {
            if (last == null || !last.equals(nums[i])) {
                list.add(nums[i]);
                getResult(i + 1, nums, result, list);
                list.remove(list.size() - 1);
                last = nums[i];
            }
        }
    }

}
