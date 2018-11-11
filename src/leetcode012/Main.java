package leetcode012;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {3,4,9,58,1994};
        for (int i = 0; i < test.length; i++) {
            System.out.println(s.intToRoman(test[i]));
        }
    }

}
