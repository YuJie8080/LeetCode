package leetcode056;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static final List<Interval> generate(int[][] nums) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        for (int[] ns : nums)
            result.add(new Interval(ns[0], ns[1]));
        return result;
    }
    
    public static final void show(List<Interval> intervals) {
        for (Interval i : intervals)
            System.out.print("[" + i.start + "," + i.end + "] ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] nums = {{5,7},{5,5},{1,1},{0,0},{3,3},{4,5},{1,1},{3,4}};
        List<Interval> intervals = generate(nums);
        Solution s = new Solution();
        List<Interval> result = s.merge(intervals);
        show(result);
    }

}
