package leetcode018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[i] + nums[j];
                    if (sum > target) {
                        for (right--; right > 0 && nums[right] == nums[right + 1]; right--);
                    } else if (sum < target) {
                        for (left++; left < nums.length && nums[left] == nums[left - 1]; left++);
                    } else {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]); list.add(nums[j]); list.add(nums[left]); list.add(nums[right]);
                        result.add(list);
                        for (right--; right > 0 && nums[right] == nums[right + 1]; right--);
                        for (left++; left < nums.length && nums[left] == nums[left - 1]; left++);
                    }
                }
            }
        }
        return result;
    }
    
}
