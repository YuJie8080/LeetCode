package leetcode061;

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int length = getListLength(head);
        k %= length;
        if (k == 0) return head;
        ListNode p = head;
        for (int i = 0; i < length - k - 1; i++) p = p.next;
        ListNode q = p;
        while (q.next != null) {
            q = q.next;
        }
        q.next = head;
        head = p.next;
        p.next = null;
        return head;
    }
    
    private int getListLength(ListNode head) {
        ListNode p = head;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }
    
}
