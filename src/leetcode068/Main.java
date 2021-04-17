package leetcode068;

import java.util.List;

import common.Output;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = { "Listen", "to", "many,", "speak", "to", "a", "few." };
        int maxWidth = 6;
        List<String> result = s.fullJustify(words, maxWidth);
        Output.list(result, "\n");
    }

}
