package leetcode090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        HashSet<String> containSet = new HashSet<>();
        getResult(0, nums, containSet, result);
        return result;
    }

    private void getResult(int n, int[] nums, HashSet<String> containSet, List<List<Integer>> result) {
        if (n == nums.length) {
            StringBuilder builder = new StringBuilder();
            List<Integer> list = new ArrayList<>();
            int last = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < last) {
                    break;
                }
                last = nums[i];
                builder.append(nums[i]);
                list.add(nums[i]);
                String str = builder.toString();
                if (!containSet.contains(str)) {
                    containSet.add(str);
                    result.add(list);
                    list = new ArrayList<>(list);
                }
            }
        } else {
            out: for (int i = n; i < nums.length; i++) {
                for (int j = n; j < i; j++) {
                    if (nums[j] == nums[i]) {
                        continue out;
                    }
                }
                swap(nums, i, n);
                getResult(n + 1, nums, containSet, result);
                swap(nums, i, n);
            }
        }
    }

    private void swap(int[] array, int a, int b) {
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    }

}
