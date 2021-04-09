package leetcode092;

/** <a>https://leetcode.com/problems/reverse-linked-list-ii/</a> */
public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left > right || head == null || head.next == null) {
            return head;
        }
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE, head);
        ListNode rightNode = fakeHead;
        for (int i = 0; i < right && rightNode != null; i++, rightNode = rightNode.next)
            ;
        if (rightNode == null) {
            return head;
        }
        ListNode leftNodeParent = fakeHead;
        for (int i = 1; i < left; i++, leftNodeParent = leftNodeParent.next)
            ;
        while (leftNodeParent.next != rightNode) {
            ListNode p = leftNodeParent.next;
            // delete
            leftNodeParent.next = leftNodeParent.next.next;
            // add
            p.next = rightNode.next;
            rightNode.next = p;
        }
        return fakeHead.next;
    }

}
