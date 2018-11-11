package leetcode012;

public class Solution2 {
    
    public String intToRoman(int num) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < keys.length - 1; i++) {
            num = cal(num, result,
                    values[i], keys[i],
                    values[i] - values[(i / 2 + 1) * 2], keys[(i / 2 + 1) * 2]);
        }
        cal(num, result,
                values[values.length - 1], keys[keys.length - 1],
                5, ' ');
        return result.toString();
    }
    
    private final int[] values = {1000, 500, 100, 50, 10, 5, 1};
    private final char[] keys = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
    
    private int cal(int num, StringBuffer result,
            int value, char key,
            int repVal, char repKey) {
        for (int i = 0; i < num / value; i++, result.append(key));
        num = num % value;
        if (value != 1 && num >= repVal) {
            num -= repVal;
            result.append(repKey);
            result.append(key);
        }
        return num;
    }
    
}
