package leetcode046;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private void fullArray(int n, int[] nums, List<List<Integer>> result) {
        if (n == nums.length) {
            ArrayList<Integer> list = new ArrayList<Integer>(nums.length);
            for (int i = 0; i < nums.length; i++)
                list.add(nums[i]);
            result.add(list);
        } else {
            for (int i = n; i < nums.length; i++) {
                {int t = nums[i]; nums[i] = nums[n]; nums[n] = t;}
                fullArray(n + 1, nums, result);
                {int t = nums[i]; nums[i] = nums[n]; nums[n] = t;}
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        fullArray(0, nums, result);
        return result;
    }
    
}
