package leetcode137;

import java.util.HashMap;
import java.util.Map.Entry;

public class Solution2 {

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            int n = map.getOrDefault(i, 0);
            n++;
            map.put(i, n);
        }
        for (Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue().equals(1)) {
                return e.getKey();
            }
        }
        return 0;
    }
    
}
