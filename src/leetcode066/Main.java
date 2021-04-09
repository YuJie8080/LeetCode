package leetcode066;

public class Main {
    
    private static int[] toDigits(String num) {
        int[] digits = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            digits[i] = num.charAt(i) - '0';
        }
        return digits;
    }
    
    private static void showDigits(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        showDigits(s.plusOne(toDigits("999")));
    }

}
