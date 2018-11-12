package leetcode040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        int negative = 0;
        for (int i : candidates) {
            if (i > 0) break;
            negative += i;
        }
        dfs(candidates, candidates.length - 1, target, negative, result, new ArrayList<Integer>());
        return result;
    }
    
    private void dfs(int[] candidates, int pointer, int target, int negative, List<List<Integer>> result, List<Integer> temp) {
        for (int i = pointer; i >= 0; i--) {
            if (i < pointer && candidates[i] == candidates[i + 1]) continue;
            target -= candidates[i];
            temp.add(candidates[i]);
            if (target == 0) {
                ArrayList<Integer> success = new ArrayList<Integer>(temp.size());
                for (Integer e : temp) success.add(e);
                result.add(success);
            } else if (target >= negative) {
                dfs(candidates, i - 1, target, negative, result, temp);
            }
            temp.remove(temp.size() - 1);
            target += candidates[i];
        }
    }
    
}
