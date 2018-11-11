package leetcode024;

public class Main {

    public static final void showList(ListNode head) {
        if (head != null) {
            System.out.println(head.val);
            showList(head.next);
        }
    }
    
    public static final ListNode toList(int[] nums) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 0; i < nums.length; i++, p = p.next) {
            p.next = new ListNode(nums[i]);
        }
        return head.next;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[0];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        Solution s = new Solution();
        showList(s.swapPairs(toList(nums)));
    }

}
