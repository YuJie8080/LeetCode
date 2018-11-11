package leetcode016;

import java.util.Arrays;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDist = Integer.MAX_VALUE;
        int closest = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                int dist = Math.abs(sum - target);
                if (dist == 0) return sum;
                if (dist < minDist) {
                    closest = sum;
                    minDist = dist;
                }
                if (sum > target) {
                    for (right--; right > 0 && nums[right] == nums[right + 1]; right--);
                } else {
                    for (left++; left < nums.length && nums[left] == nums[left - 1]; left++);
                }
            }
        }
        return closest;
    }
    
}
