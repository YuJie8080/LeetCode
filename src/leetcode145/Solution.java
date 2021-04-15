package leetcode145;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Boolean> visitStack = new LinkedList<>();
        List<Integer> visitResult = new LinkedList<>();
        stack.push(root);
        visitStack.push(false);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            boolean isVisit = visitStack.pop();
            if (isVisit) {
                visitResult.add(node.val);
                continue;
            }
            stack.push(node);
            visitStack.push(true);
            if (node.right != null) {
                stack.push(node.right);
                visitStack.push(false);
            }
            if (node.left != null) {
                stack.push(node.left);
                visitStack.push(false);
            }
        }
        return visitResult;
    }

}
