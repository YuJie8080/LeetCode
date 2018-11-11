package leetcode055;

public class Solution {

    public boolean canJump(int[] nums) {
        if (nums.length == 0) return false;
        int range = 0;
        for (int i = 0; i <= range; i++) {
            range = nums[i] + i > range ? nums[i] + i : range;
            if (range >= nums.length - 1) return true;
        }
        return false;
    }
    
}
