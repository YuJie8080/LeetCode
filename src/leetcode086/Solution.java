package leetcode086;

/** <a>https://leetcode.com/problems/partition-list/</a>*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        // search
        if (head.val == x) {
            ListNode p = head;
            while (p.next != null) {
                if (p.next.val < x) {
                    ListNode q = p.next;
                    // delete
                    p.next = q.next;
                    // push
                    q.next = head;
                    head = q;
                    break;
                }
                p = p.next;
            }
        }
        ListNode p = head;// pre x
        while (p.next != null) {
            if (p.next.val == x) {
                break;
            }
            p = p.next;
        }
        
        // move
        ListNode q = p;// pre less than x
        while (q.next != null) {
            if (q.next.val < x) {
                ListNode r = q.next;
                // delete
                q.next = r.next;
                // insert
                r.next = p.next;
                p.next = r;
                p = r;
            } else {
                q = q.next;
            }
        }
        return head;
    }
    
}
