package leetcode017;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    private final char[][] buttons = {{'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        if (digits.length() == 0) return result;
        ArrayList<String> temp;
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            temp = new ArrayList<String>();
            char[] ct = buttons[digits.charAt(i) - '2'];
            for (int j = 0; j < result.size(); j++) {
                for (int k = 0; k < ct.length; k++) temp.add(result.get(j) + ct[k]);
            }
            result = temp;
        }
        return result;
    }
    
}
