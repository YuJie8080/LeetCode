package leetcode025;

public class Main {
    
    public static final void showList(ListNode head) {
        if (head != null) {
            System.out.println(head.val);
            showList(head.next);
        }
    }

    public static void main(String[] args) {
        int[] values = {1,2,3,4,5};
        ListNode head = new ListNode(values[0]);
        ListNode p = head;
        for (int i = 1; i < values.length; i++) {
            p.next = new ListNode(values[i]);
            p = p.next;
        }
        Solution s = new Solution();
        head = s.reverseKGroup(null, 1);
        showList(head);
    }

}
