package leetcode080;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,1,1,2,2,3};
        int len = s.removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
