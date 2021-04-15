package leetcode045;

import common.Input;
import common.Output;

public class Main {

    public static void main(String[] args) {
        int[] nums = Input.randomArray(10, 0, 5);
        Output.array(nums);
//        int[] nums = { 2, 3, 0, 1, 4 };
        Solution s = new Solution();
        System.out.println(s.jump(nums));
    }

}
