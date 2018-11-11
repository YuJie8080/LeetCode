package leetcode023;

public class Main {

    public static final ListNode[] toListNode(int[][] nums) {
        ListNode[] node = new ListNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            try {
                node[i] = new ListNode(nums[i][0]);
                ListNode p = node[i];
                for (int j = 1; j < nums[i].length; j++) {
                    p.next = new ListNode(nums[i][j]);
                    p = p.next;
                }
            } catch (Exception e) {
                node[i] = null;
            }
        }
        return node;
    }
    
    public static final void showList(ListNode head) {
        if (head != null) {
            System.out.println(head.val);
            showList(head.next);
        }
    }
    
    public static void main(String[] args) {
        int[][] nums = {{},{}};
        Solution s = new Solution();
        showList(s.mergeKLists(toListNode(nums)));
    }

}
