package leetcode065;

public class Main {

    public static void main(String[] args) {
        String[] nums = { "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93",
                "-123.456e789", "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53" };
        Solution s = new Solution();
        for (int i = 0; i < nums.length; i++) {
            boolean result = s.isNumber(nums[i]);
            System.out.println(nums[i] + "\t" + result);
        }
    }

}
