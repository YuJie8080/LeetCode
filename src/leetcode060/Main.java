package leetcode060;

public class Main {

    public static void main(String[] args) {
        int n = 4;
        for (int k = 1; k <= 24; k++) {
            System.out.println(new Solution().getPermutation(n, k));
        }
//        System.out.println(new Solution().getPermutation(4, 4));
    }

}
