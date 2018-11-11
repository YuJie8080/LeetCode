package leetcode023;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeK(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeK(ListNode[] lists, int a, int b) {
        if(a == b)return lists[a];
        if(a + 1 == b) return merge2(lists[a], lists[b]);
        int mid = a + (b - a)/2;
        ListNode list1 = mergeK(lists, a, mid);
        ListNode list2 = mergeK(lists, mid + 1, b);
        return merge2(list1, list2);
    }
    
    private ListNode merge2(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = merge2(list1.next, list2);
            return list1;
        } else {
            list2.next = merge2(list1, list2.next);
            return list2;
        }
    }

}
