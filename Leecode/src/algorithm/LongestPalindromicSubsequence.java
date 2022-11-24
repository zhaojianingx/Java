package algorithm;

/**
 * @author zjn
 **/
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubSeq(String s) {
        int len = s.length();
        // dp[i][j]表示字符串在[i,j]范围内最长的回文子序列的长度
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            // 从后往前遍历，保证情况不漏
            dp[i][i] = 1; // 初始化
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
                }
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubSeq("bbbab"));
    }
}
