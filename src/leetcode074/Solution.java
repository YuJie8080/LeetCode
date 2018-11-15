package leetcode074;

/** <a>https://leetcode.com/problems/search-a-2d-matrix/</a>*/
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0 || target < matrix[0][0]) return false;
        int top = 0, bottom = m - 1;
        while (top < bottom) {
            int mid = (top + bottom) / 2;
            if (target >= matrix[bottom][0]) {
                break;
            } else if (target >= matrix[mid][0]) {
                if (top == mid) bottom = mid;
                top = mid;
            } else {
                bottom = mid - 1;
            }
        }
        
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[bottom][mid] == target) return true;
            if (target > matrix[bottom][mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
    
}
