package leetcode032;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] test = {"(()(()", "())())", "(())()", "(())(()", "(()))()", ")()())", "))))((()(("};
        System.out.println(s.longestValidParentheses(test[6]));
    }

}
