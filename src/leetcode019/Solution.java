package leetcode019;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLength(head);
        if (n <= 0 || n > len) return head;
        if (n == len) return head.next;
        remove(head, len - n);
        return head;
    }
    
    private int getLength(ListNode head) {
        if (head == null) return 0;
        return getLength(head.next) + 1;
    }
    
    private void remove(ListNode head, int index) {
        if (index == 1) {
            head.next = head.next.next;
        } else {
            remove(head.next, index - 1);
        }
    }
    
}
