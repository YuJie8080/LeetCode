package leetcode024;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    
    public ListNode swapPairs(ListNode head) {
        ListNode t = new ListNode(0);
        t.next = head;
        ListNode p = t;
        while (p.next != null && p.next.next != null) {
            ListNode q = p.next;
            ListNode r = p.next.next.next;
            p.next = p.next.next;
            q.next = r;
            p.next.next = q;
            p = p.next.next;
        }
        return t.next;
    }
    
}
