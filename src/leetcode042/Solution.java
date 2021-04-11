package leetcode042;

/** <a>https://leetcode.com/problems/trapping-rain-water/</a> */
public class Solution {

    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int maxIndex = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[maxIndex]) {
                maxIndex = i;
            }
        }
        int result = 0;
        // left
        int currentHeight = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (height[i] > currentHeight) {
                currentHeight = height[i];
            } else {
                result += currentHeight - height[i];
            }
        }
        // right
        currentHeight = 0;
        for (int i = height.length - 1; i > maxIndex; i--) {
            if (height[i] > currentHeight) {
                currentHeight = height[i];
            } else {
                result += currentHeight - height[i];
            }
        }
        return result;
    }

}
