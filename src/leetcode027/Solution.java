package leetcode027;

public class Solution {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int removeCount = 0;
        for (int i = 0; i + removeCount < nums.length;) {
            if (nums[i + removeCount] == val) {
                removeCount++;
            } else {
                nums[i] = nums[i + removeCount];
                i++;
            }
        }
        return nums.length - removeCount;
    }

}
