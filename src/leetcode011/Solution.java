package leetcode011;

public class Solution {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = cap(height, left, right);
        while (left < right) {
            if (height[left] < height[right]) {
                int l = left;
                for (++left; left < right && height[left] <= height[l]; left++);
            } else {
                int r = right;
                for (--right; left < right && height[right] <= height[r]; right--);
            }
            int t = cap(height, left, right);
            max = t > max ? t : max;
        }
        return max;
    }
    
    private int cap(int[] height, int left, int right) {
        return (height[left] < height[right] ? height[left] : height[right])
                * (right - left);
    }
    
}
