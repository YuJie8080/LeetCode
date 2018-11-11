package leetcode113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    
    private void dfs(TreeNode root, LinkedList<Integer> list, int sum, int now, List<List<Integer>> result) {
        list.add(root.val);
        if (root.left != null) {
            dfs(root.left, list, sum, now + root.val, result);
        }
        if (root.right != null) {
            dfs(root.right, list, sum, now + root.val, result);
        }
        if (root.left == null && root.right == null && now + root.val == sum) {
            List<Integer> t = new ArrayList<Integer>();
            for (int i : list)
                t.add(i);
            result.add(t);
        }
        list.removeLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root != null)
            dfs(root, list, sum, 0, result);
        return result;
    }
    
}
