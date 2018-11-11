package leetcode049;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final ArrayList<Integer> prime(int len) {
        boolean[] isPrime = new boolean[len];
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) continue;
            nums.add(i);
            if (i > isPrime.length / i) continue;
            for (int j = i * i; j < isPrime.length; j += i)
                isPrime[j] = true;
        }
        return nums;
    }
    
    public static final void show(List<List<String>> result) {
        for (int i = 0; i < result.size(); i++) {
            List<String> list = result.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + ",");
            }
            System.out.println();
        }
    }
    
    public static final void dsc(int a, int b) {
        System.out.println((int) Math.sqrt(a * a - b * b));
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> list = prime(150);
        for (int i = 0; i < 26; i++)
            System.out.print(list.get(i) + ", ");
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        Solution s = new Solution();
//        List<List<String>> result = s.groupAnagrams(strs);
//        show(result);
//        System.out.println(s.toId("eolg"));
//        System.out.println(s.toId("incana"));
    }

}
