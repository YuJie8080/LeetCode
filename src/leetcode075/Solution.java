package leetcode075;

/** <a>https://leetcode.com/problems/sort-colors/</a>*/
public class Solution {
    
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        int current = 0;
        while (current <= two) {
            if (nums[current] == 0) {
                swap(nums, current++, zero++);
            } else if (nums[current] == 2) {
                swap(nums, current, two--);
            } else {
                current++;
            }
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
    
}
