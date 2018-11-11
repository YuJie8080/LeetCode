package leetcode056;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class Solution {
    
    private void sort(Interval[] array, int start, int end) {
        if (start < end - 1) {
            int mid = start + (end - start >> 1);
            sort(array, start, mid);
            sort(array, mid, end);
            Interval[] ta = new Interval[end - start];
            int p = 0, lp = start, rp = mid;
            while (lp < mid && rp < end) {
                if (array[lp].start < array[rp].start ||
                        (array[lp].start == array[rp].start && array[lp].end < array[rp].end))
                    ta[p++] = array[lp++];
                else
                    ta[p++] = array[rp++];
            }
            if (lp < mid)
                for (; lp < mid; lp++)
                    ta[p++] = array[lp];
            if (rp < end)
                for (; rp < end; rp++)
                    ta[p++] = array[rp];
            for (int i = 0; i < ta.length; i++)
                array[start + i] = ta[i];
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Interval[] array = new Interval[intervals.size()];
        array = intervals.toArray(array);
        sort(array, 0, array.length);
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (array.length == 0) return result;
        int p = 0;
        result.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i].start > result.get(p).end) {
                result.add(array[i]);
                p++;
            } else {
                int max = result.get(p).end;
                max = array[i].end > max ? array[i].end : max;
                result.get(p).end = max;
            }
        }
        return result;
    }
    
}
