package leetcode057;

import common.ShowDetail;

public class Main {

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 6, 9 } };
        int[] newInterval = { 4, 5 };
        Solution s = new Solution();
        int[][] result = s.insert(intervals, newInterval);
        for (int i = 0; i < result.length; i++) {
            ShowDetail.array(result[i]);
        }
    }

}
