package leetcode015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        if (nums[nums.length - 1] < 0 || nums[0] > 0) return result;
        int zero = search(nums, 0, 0, nums.length);
        for (; zero + 1 < nums.length && nums[zero + 1] == nums[zero]; zero++);
        for (int i = 0; i < zero; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int k = zero; k < nums.length; k++) {
                if (k + 1 < nums.length && nums[k] == nums[k + 1]) continue;
                int target = - (nums[i] + nums[k]);
                int j = search(nums, target, i + 1, k);
                if (j > i && j < k && nums[j] == target) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]); list.add(nums[j]); list.add(nums[k]);
                    result.add(list);
                }
            }
        }
        return result;
    }
    
    public int search(int[] nums, int target, int left, int right) {
        int mid = left + (right - left >> 1);
        if (nums[mid] == target) return mid;
        if (left > right) return left;
        if (nums[mid] < target) {
            return search(nums, target, mid + 1, right);
        } else {
            return search(nums, target, left, mid - 1);
        }
    }
    
}
