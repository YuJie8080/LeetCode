package leetcode089;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> grayCode = s.grayCode(1);
        for (Integer i : grayCode) {
            System.out.println(i + "\t" + Integer.toBinaryString(i));
        }
    }

}
