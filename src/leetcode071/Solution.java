package leetcode071;

/** <a>https://leetcode.com/problems/simplify-path/</a>*/
public class Solution {

    public String simplifyPath(String path) {
        String[] slide = path.split("/");
        String[] stack = new String[slide.length];
        int pointer = 0;
        for (int i = 0; i < slide.length; i++) {
            if (slide[i].equals("..")) {
                pointer--;
                pointer = pointer > 0 ? pointer : 0;
            } else if (slide[i].equals(".") || slide[i].equals("")) {
                
            } else {
                stack[pointer++] = slide[i];
            }
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < pointer; i++) {
            buffer.append("/");
            buffer.append(stack[i]);
        }
        String result = buffer.toString();
        return result.equals("") ? "/" : result;
    }
    
}
