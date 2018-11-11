package leetcode034;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1, -1};
        int left = binarySearch(nums, target - 0.5, 0, nums.length);
        int right = binarySearch(nums, target + 0.5, 0, nums.length);
        if (right > left) return new int[] {left + 1, right};
        return new int[] {-1, -1};
    }
    
    public int binarySearch(int[] nums, double target, int left, int right) {
        if (left > right) return right;
        if (left >= nums.length) return nums.length - 1;
        int mid = left + (right - left >> 1);
        if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, right);
        } else {
            return binarySearch(nums, target, left, mid - 1);
        }
    }
    
}
