package leetcode031;

public class Solution {

    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                reverse(nums, i, nums.length - 1);
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > nums[i - 1]) {
                        swap(nums, i - 1, j);
                        return;
                    }
                }
                return;
            }
        }
        reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] nums, int a, int b) {
        for (int i = 0; i < b - a + 1 >> 1; i++) {
            swap(nums, a + i, b - i);
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
    
}
