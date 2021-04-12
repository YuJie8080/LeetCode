package leetcode010;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "aaba";
        String pattern = "ab*a*c*a";
        System.out.println(s.isMatch(str, pattern));
    }

}
