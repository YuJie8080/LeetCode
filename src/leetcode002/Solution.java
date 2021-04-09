package leetcode002;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum;
        ListNode result = null;
        ListNode p = null;
        while (l1 != null || l2 != null || carry == 1) {
            int a = 0, b = 0;

            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }

            sum = a + b + carry;
            carry = 0;
            if (sum >= 10) {
                sum -= 10;
                carry++;
            }

            ListNode temp = new ListNode(sum);
            if (result == null) {
                result = temp;
                p = result;
            } else {
                p.next = temp;
                p = p.next;
            }
        }

        return result;
    }

}
