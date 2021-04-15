package leetcode145;

import java.util.List;

import common.Input;
import common.Output;

public class Main {

    public static void main(String[] args) throws Exception {
        Integer[] nums = { 1, null, 2, null, null, 3 };
        TreeNode root = Input.arrayToTreeNode(nums, TreeNode.class);
        Solution s = new Solution();
        List<Integer> result = s.postorderTraversal(root);
        Output.list(result);
    }

}
