package leetcode093;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> ipList = s.restoreIpAddresses("25525511135");
        for (String ip : ipList) {
            System.out.println(ip);
        }
    }

}
