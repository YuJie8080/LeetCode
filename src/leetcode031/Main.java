package leetcode031;

public class Main {

    public static void show(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] nums = {1,1,3};
        Solution s = new Solution();
        for (int i = 0; i < 6; i++) {
            s.nextPermutation(nums);
            show(nums);
        }
    }

}
