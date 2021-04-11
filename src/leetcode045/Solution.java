package leetcode045;

/** <a>https://leetcode.com/problems/jump-game-ii/</a> */
public class Solution {

    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] step = new int[nums.length];
        step[0] = 0;
        for (int i = 1; i < step.length; i++) {
            step[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            if (step[i] == Integer.MAX_VALUE) {
                return -1;
            }
            int s = step[i] + 1;
            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                step[i + j] = s > step[i + j] ? step[i + j] : s;
            }
        }
        return step[step.length - 1];
    }

}
