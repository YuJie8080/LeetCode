package leetcode067;

public class Solution {

    public String addBinary(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        if (ac.length < bc.length) {
            char[] tc = ac;
            ac = bc;
            bc = tc;
        }
        char[] sc = new char[ac.length + 1];
        sc[0] = '0';
        boolean addBit = false;
        int i = 0;
        while (i < bc.length) {
            int bi = bc.length - 1 - i;
            int ai = ac.length - 1 - i;
            int si = sc.length - 1 - i;
            int bitSum = ac[ai] - '0' + bc[bi] - '0';
            bitSum = addBit ? bitSum + 1 : bitSum;
            addBit = false;
            if (bitSum >= 2) {
                addBit = true;
                sc[si] = (char) (bitSum - 2 + '0');
            } else {
                sc[si] = (char) (bitSum + '0');
            }
            i++;
        }
        while (i < ac.length) {
            int ai = ac.length - 1 - i;
            int si = sc.length - 1 - i;
            int bitSum = ac[ai] - '0';
            bitSum = addBit ? bitSum + 1 : bitSum;
            addBit = false;
            if (bitSum >= 2) {
                addBit = true;
                sc[si] = (char) (bitSum - 2 + '0');
            } else {
                sc[si] = (char) (bitSum + '0');
            }
            i++;
        }
        if (addBit) {
            sc[0] = '1';
        }
        return sc[0] == '0' ? new String(sc, 1, sc.length - 1) : new String(sc);
    }

}
