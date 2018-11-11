package leetcode025;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = getLength(head);
        if (k > len || k == 0 || len == 0) return head;
        ListNode t = new ListNode(0);
        t.next = head;
        head = t;
        ListNode base = head;
        ListNode p = head;
        ListNode result = head;
        for (int i = 0; i < k; i++) result = result.next;
        for (int i = 0; i < len / k * k; i++) {
            if (i % k == 0) {
                base = p;
            }
            ListNode q = p.next;
            p.next = q.next;
            q.next = base.next;
            base.next = q;
            if (p == base) p = p.next;
        }
        return result;
    }
    
    private int getLength(ListNode head) {
        if (head == null) return 0;
        return getLength(head.next) + 1;
    }
    
}
