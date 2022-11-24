package algorithm;

/**
 * @author zjn
 **/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        // 初始值为首位元素
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            // 挨着对比
            while (j < res.length() && j < strs[i].length() && res.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            // substring是左闭右开的
            res = res.substring(0, j);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
