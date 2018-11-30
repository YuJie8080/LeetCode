package leetcode080;

/** <a>https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/</a>*/
public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int current = 0;
        int time = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[current] && time == 2) {
                for (; nums[i] < nums[current]; i++);
            } else {
                if (nums[i] == nums[current]) {
                    time++;
                } else {
                    time = 1;
                }
                nums[++current] = nums[i];
            }
        }
        return current + 1;
    }
    
}
