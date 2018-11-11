package leetcode004;

public class Solution2 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0)
            return (nums2[nums2.length - 1 >> 1] + nums2[nums2.length >> 1]) / 2.0;
        if (nums2.length == 0)
            return (nums1[nums1.length - 1 >> 1] + nums1[nums1.length >> 1]) / 2.0;
        if (nums1[min(nums1.length - 1, nums1.length + (nums2.length - 1 - nums1.length >> 1))] <= nums2[0]) {
            if (nums1.length < nums2.length)
                return (nums2[(nums1.length + nums2.length - 1 >> 1) - nums1.length] +
                        nums2[(nums1.length + nums2.length >> 1) - nums1.length]) / 2.0;
            else if (nums1.length > nums2.length)
                return (nums1[nums1.length + nums2.length - 1 >> 1] +
                        min(nums1[nums1.length + nums2.length >> 1], nums2[0])) / 2.0;
            else
                return (nums1[nums1.length - 1] + nums2[0]) / 2.0;
        }
        if (nums2[min(nums2.length - 1, nums1.length + (nums2.length - 1 - nums1.length >> 1))] <= nums1[0]) {
            if (nums2.length < nums1.length)
                return (nums1[(nums1.length + nums2.length - 1 >> 1) - nums2.length] +
                        nums1[(nums1.length + nums2.length >> 1) - nums2.length]) / 2.0;
            else if (nums2.length > nums1.length)
                return (nums2[nums2.length + nums1.length - 1 >> 1] +
                        min(nums2[nums2.length + nums1.length >> 1], nums1[0])) / 2.0;
            else
                return (nums2[nums2.length - 1] + nums1[0]) / 2.0;
        }
        int[] result = search(nums1.length + (nums2.length - nums1.length + 1 >> 1),
                nums1, 0, nums2, 0);
        double sum;
        if (result[0] == -1)
            sum = nums2[result[1]];
        else if (result[1] == -1)
            sum = nums1[result[0]];
        else
            sum = nums1[result[0]] > nums2[result[1]] ?
                nums1[result[0]] : nums2[result[1]];
        if ((nums1.length % 2 + nums2.length % 2) % 2 == 0) {
            if (result[0] + 1 == nums1.length)
                return (sum + nums2[result[1] + 1]) / 2;
            if (result[1] + 1 == nums2.length)
                return (sum + nums1[result[0] + 1]) / 2;
            return (sum + (nums1[result[0] + 1] < nums2[result[1] + 1] ?
                    nums1[result[0] + 1] : nums2[result[1] + 1])) / 2;
        }
        return sum;
    }
    
    private int[] search(int target, int[] nums1, int p1, int[] nums2, int p2) {
        if (p1 + 1 == nums1.length) {
            int t = target - 2 - p1;
            for (; p1 > -1 && t + 1 < nums2.length && nums1[p1] > nums2[t + 1]; p1--, t++);
            return new int[] {p1, t};
        }
        if (p2 + 1 == nums2.length) {
            int t = target - 2 - p2;
            for (; p2 > -1 && t + 1 < nums1.length && nums2[p2] > nums1[t + 1]; p2--, t++);
            return new int[] {t, p2};
        }
        int inc = (target - p1 - p2 - 2 >> 1);
        if (p1 + p2 + 2 == target) {
            return new int[] {p1, p2};
        } else if (p1 + p2 + 2 < target) {
            if (inc < 1) inc = 1;
            inc = min(inc, nums1.length - 1 - p1, nums2.length - 1 - p2);
            if (nums1[p1 + inc] < nums2[p2 + inc])
                return search(target, nums1, p1 + inc, nums2, p2);
            else
                return search(target, nums1, p1, nums2, p2 + inc);
        } else {
            if (inc > -1) inc = 1;
            inc = min(inc, nums1.length - 1 - p1, nums2.length - 1 - p2);
            if (nums1[p1 - inc] > nums2[p2 - inc])
                return search(target, nums1, p1 - inc, nums2, p2);
            else
                return search(target, nums1, p1, nums2, p2 - inc);
        }
    }
    
    private int min(int... a) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) min = a[i] < min ? a[i] : min;
        return min;
    }
    
}
