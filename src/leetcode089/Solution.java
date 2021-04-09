package leetcode089;

import java.util.ArrayList;
import java.util.List;

/** <a>https://leetcode.com/problems/gray-code/</a> */
public class Solution {

    public List<Integer> grayCode(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>(1 << n);
        result.add(0);
        result.add(1);
        for (int i = 1; i < n; i++) {
            for (int j = (1 << i) - 1; j >= 0; j--) {
                result.add(result.get(j) + (1 << i));
            }
        }
        return result;
    }

}
