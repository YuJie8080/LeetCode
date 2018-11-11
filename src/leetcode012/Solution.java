package leetcode012;

public class Solution {

    private final String[] single = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private final String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private final String[] hundred = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private final String[] thousand = {"", "M", "MM", "MMM"};
    private final String[][] roman = {thousand, hundred, ten, single};
    
    public String intToRoman(int num) {
        StringBuffer result = new StringBuffer();
        int base = 1000;
        for (int i = 0; i < roman.length; i++, base /= 10) {
            result.append(roman[i][num / base]);
            num %= base;
        }
        return result.toString();
    }
    
}
