package leetcode082;

/** <a>https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/</a> */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE, head);
        ListNode p = fakeHead;
        ListNode q = p.next != null ? p.next.next : null;
        while (p != null && p.next != null && q != null) {
            if (p.next.val == q.val) {
                q = q.next;
            } else {
                if (p.next.next != q) {
                    p.next = q;
                    q = p.next != null ? p.next.next : null;
                } else {
                    p = p.next;
                    q = p.next != null ? p.next.next : null;
                }
            }
        }
        if (q == null && p.next.next != q) {
            p.next = q;
        }
        return fakeHead.next;
    }
    
}
