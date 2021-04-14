package leetcode057;

public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length + 1][2];
        int i = 0;
        for (; i < intervals.length; i++) {
            if (intervals[i][1] >= newInterval[0]) {
                break;
            }
            result[i] = intervals[i];
        }
        int index = i;
        result[index] = newInterval;
        for (; i < intervals.length; i++) {
            if (!merge(result[index], intervals[i])) {
                break;
            }
        }
        index++;
        for (; i < intervals.length; i++, index++) {
            result[index] = intervals[i];
        }
        int[][] finalResult = new int[index][];
        for (int j = 0; j < index; j++) {
            finalResult[j] = result[j];
        }
        return finalResult;
    }

    private boolean merge(int[] a, int[] b) {
        int al = a[0];
        int ar = a[1];
        int bl = b[0];
        int br = b[1];
        if (al <= bl && ar >= br) {
            a[0] = al;
            a[1] = ar;
            return true;
        }
        if (bl <= al && br >= ar) {
            a[0] = bl;
            a[1] = br;
            return true;
        }
        if (al <= bl && ar <= br && bl <= ar) {
            a[0] = al;
            a[1] = br;
            return true;
        }
        if (bl <= al && br <= ar && al <= br) {
            a[0] = bl;
            a[1] = ar;
            return true;
        }
        return false;
    }

}
