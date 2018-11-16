package leetcode077;

import java.util.ArrayList;
import java.util.List;

/** <a>https://leetcode.com/problems/combinations/</a>*/
public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k == 0) return result;
        dfs(n, k, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void dfs(int n, int k, int c, ArrayList<Integer> now, List<List<Integer>> result) {
        if (now.size() == k) {
            ArrayList<Integer> temp = new ArrayList<Integer>(now.size());
            for (Integer i : now) temp.add(i);
            result.add(temp);
        } else {
            for (int i = c + 1; i <= n - k + now.size() + 1; i++) {
                now.add(i);
                dfs(n, k, i, now, result);
                now.remove(now.size() - 1);
            }
        }
    }
    
}
