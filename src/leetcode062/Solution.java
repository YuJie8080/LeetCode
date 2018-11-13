package leetcode062;

/** <a>https://leetcode.com/problems/unique-paths/</a>*/
public class Solution {

    /**
     * Solution formula.
     *          a*(a+1)*(a+2)*...*(a+b-2)
     * result = -------------------------
     *                     (b-1)!
     * If 'b' equal to 1, return 1.
     * And 'b' must less than or equal to 'a'. 
     * I think the return type should be 'long'.
     * If not, the function can't solve the problems such as 'm=15, n=19'.
     * */
    public long uniquePaths(int m, int n) {
        int a, b;
        if (m > n) { a = m; b = n; }
        else { b = m; a = n; }
        long down = 1;
        for (int i = 1; i < b; i++) down *= i;
        long up = 1;
        for (int i = 0; i < b - 1; i++) up *= (a + i);
        return up / down;
    }
    
}
