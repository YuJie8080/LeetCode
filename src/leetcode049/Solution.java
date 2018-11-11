package leetcode049;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    private static final long[] MAGIC = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
    
    private long toId(String str) {
        char[] cs = str.toCharArray();
        long result = 1;
        for (int i = 0; i < cs.length; i++) {
            result *= MAGIC[cs[i] - 'a'];
        }
        return result;
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Long, List<String>> map = new HashMap<Long, List<String>>();
        for (String str : strs) {
            long id = toId(str);
            List<String> list = map.getOrDefault(id, new ArrayList<String>());
            list.add(str);
            map.put(id, list);
        }
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }
    
}
