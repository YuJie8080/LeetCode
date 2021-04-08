package leetcode090;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2 };
        Solution s = new Solution();
        List<List<Integer>> result = s.subsetsWithDup(nums);
        for (List<Integer> list : result) {
            for (Integer item : list) {
                System.out.print(item + ",");
            }
            System.out.println();
        }
    }

}
