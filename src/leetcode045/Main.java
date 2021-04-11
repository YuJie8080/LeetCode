package leetcode045;

import common.RandomInput;
import common.ShowDetail;

public class Main {

    public static void main(String[] args) {
        int[] nums = RandomInput.array(10, 0, 5);
        ShowDetail.array(nums);
//        int[] nums = { 2, 3, 0, 1, 4 };
        Solution s = new Solution();
        System.out.println(s.jump(nums));
    }

}
