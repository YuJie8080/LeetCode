package leetcode137;

public class Solution {

    public int singleNumber(int[] nums) {
        int r1 = 0;
        int r2 = 0;
        for (int n : nums) {
            r1 = (n ^ r1) & ~r2;
            r2 = (n ^ r2) & ~r1;
        }
        return r1;
    }
    
}
