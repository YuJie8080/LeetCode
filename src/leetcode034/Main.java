package leetcode034;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        Solution s = new Solution();
        System.out.println(s.binarySearch(nums, target + 0.5, 0, nums.length));
//        int[] res = s.searchRange(nums, target);
//        System.out.println(res[0]);
//        System.out.println(res[1]);
    }

}
