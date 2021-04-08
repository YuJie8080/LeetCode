package leetcode090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/** <a>https://leetcode.com/problems/subsets-ii/</a> */
@Deprecated
public class Solution {

    /**
     * 未解决
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        HashSet<String> containSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums.length - i; j++) {
                getResult(i, j, nums, containSet, result);
            }
        }
        return result;
    }

    private void getResult(int start, int bit, int[] nums, HashSet<String> containSet, List<List<Integer>> result) {
        if (start + bit > nums.length) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(nums[start]);
        for (int i = 1; i < bit; i++) {
            builder.append(",").append(nums[start + i]);
        }
        String record = builder.toString();
        if (containSet.contains(record)) {
            return;
        }
        containSet.add(record);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < bit; i++) {
            list.add(nums[start + i]);
        }
        result.add(list);
    }

}
