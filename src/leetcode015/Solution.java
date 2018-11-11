package leetcode015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            int target = - nums[i];
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum > target) {
                    for (right--; right > 0 && nums[right] == nums[right + 1]; right--);
                } else if (sum < target) {
                    for (left++; left < nums.length && nums[left] == nums[left - 1]; left++);
                } else {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]); list.add(nums[left]); list.add(nums[right]);
                    result.add(list);
                    for (right--; right > 0 && nums[right] == nums[right + 1]; right--);
                    for (left++; left < nums.length && nums[left] == nums[left - 1]; left++);
                }
            }
        }
        return result;
    }
    
}
