package algorithm;

/**
 * @author zjn
 **/
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String s1 = "";
        String s2 = "";
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 分两种情况，即一个元素作为中心点，两个元素作为中心点
            s1 = extend(s, i, i); // 情况1
            res = s1.length() > res.length() ? s1 : res;
            s2 = extend(s, i, i + 1); // 情况2
            res = s2.length() > res.length() ? s2 : res;
        }
        return res;
    }

    private String extend(String s, int start, int end) {
        String temp = "";
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            temp = s.substring(start, end + 1); // Java中substring是左闭右开的，所以要+1
            // 向两边扩散
            start--;
            end++;
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
    }
}
