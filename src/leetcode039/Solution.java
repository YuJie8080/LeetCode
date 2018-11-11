package leetcode039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(candidates, candidates.length - 1, target, result, new ArrayList<Integer>());
        return result;
    }
    
    private void dfs(int[] candidates, int pointer, int target, List<List<Integer>> result, List<Integer> temp) {
        for (int i = pointer; i >= 0; i--) {
            target -= candidates[i];
            temp.add(candidates[i]);
            if (target > 0) {
                dfs(candidates, i, target, result, temp);
            } else if (target == 0) {
                ArrayList<Integer> success = new ArrayList<Integer>(temp.size());
                for (Integer e : temp) success.add(e);
                result.add(success);
            }
            temp.remove(temp.size() - 1);
            target += candidates[i];
        }
    }
    
}
