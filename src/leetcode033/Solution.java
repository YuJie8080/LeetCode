package leetcode033;

public class Solution {

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        if (nums[left] < nums[right]) return nbs(nums, target, left, right);
        else if (nums[left] > nums[right]) return ubs(nums, target, left, right);
        else return nums[left] == target ? left : -1;
    }
    
    private int nbs(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left >> 1);
        if (nums[mid] == target) return mid;
        if (nums[mid] < target) return nbs(nums, target, mid + 1, right);
        else return nbs(nums, target, left, mid - 1);
    }
    
    private int ubs(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        if (nums[left] < nums[right]) return nbs(nums, target, left, right);
        if (target > nums[right] && target < nums[left]) return -1;
        if (right - left < 2) {
            if (nums[left] == target) return left;
            else if (nums[right] == target) return right;
            return -1;
        }
        int mid = left + (right - left >> 1);
        if (nums[mid] == target) return mid;
        if (nums[mid] > nums[left]) {
            if (nums[mid] > target && nums[left] <= target) return nbs(nums, target, left, mid - 1);
            else return ubs(nums, target, mid + 1, right);
        } else {
            if (nums[mid] < target && nums[right] >= target) return nbs(nums, target, mid + 1, right);
            else return ubs(nums, target, left, mid - 1);
        }
    }
    
}
