package leetcode086;

/** <a>https://leetcode.com/problems/partition-list/</a>*/

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE, head);
        ListNode insert = fakeHead;
        while (insert.next != null) {
            if (insert.next.val >= x) {
                break;
            }
            insert = insert.next;
        }
        ListNode p = insert;
        while (p.next != null) {
            if (p.next.val < x) {
                ListNode q = p.next;
                p.next = p.next.next;
                q.next = insert.next;
                insert.next = q;
                insert = insert.next;
            } else {
                p = p.next;
            }
        }
        return fakeHead.next;
    }

}
