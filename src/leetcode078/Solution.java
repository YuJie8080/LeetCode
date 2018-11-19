package leetcode078;

import java.util.ArrayList;
import java.util.List;

/** <a>https://leetcode.com/problems/subsets/</a>*/
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        if (nums.length == 0) return result;
        dfs(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void dfs(int[] nums, int n, ArrayList<Integer> now, ArrayList<List<Integer>> result) {
        for (int i = n; i < nums.length; i++) {
            now.add(nums[i]);
            ArrayList<Integer> temp = new ArrayList<Integer>(now.size());
            for (Integer e : now) temp.add(e);
            result.add(temp);
            dfs(nums, i + 1, now, result);
            now.remove(now.size() - 1);
        }
    }
    
}
