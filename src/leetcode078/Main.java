package leetcode078;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> result = s.subsets(new int[] {1,2,3,4});
        System.out.println(result);
    }

}
