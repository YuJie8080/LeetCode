package leetcode023;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution2 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int n = getFirst(lists);
        if (n == -1) return null;
        ListNode head = lists[n];
        for (int i = n + 1; i < lists.length; i++) {
            if (lists[i] == null) continue;
            head = head.val > lists[i].val ?
                    merge2Lists(lists[i], head) : merge2Lists(head, lists[i]);
        }
        return head;
    }
    
    private int getFirst(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) return i;
        }
        return -1;
    }
    
    private ListNode merge2Lists(ListNode list1, ListNode list2) {
        ListNode head = list1;
        ListNode p = list1;
        ListNode start = list2;
        ListNode end = list2;
        for (; p.next != null && p.next.val < start.val; p = p.next);
        while (end.next != null && p.next != null) {
            if (end.next.val > p.next.val) {
                ListNode next = end.next;
                ListNode q = p.next;
                p.next = start;
                end.next = q;
                p = q;
                for (; p.next != null && p.next.val < next.val; p = p.next);
                start = next;
                end = next;
            } else {
                end = end.next;
            }
        }
        if (p.next == null) {
            p.next = start;
        } else if (end.next == null) {
            ListNode q = p.next;
            p.next = start;
            end.next = q;
        }
        return head;
    }
    
}
