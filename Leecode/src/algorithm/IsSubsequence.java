package algorithm;

/**
 * @author zjn
 **/
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        // dp[i][j]表示以下标i - 1为结尾的字符串s, 和以下标j - 1为结尾的字符串t，相同子序列的长度
        int length1 = s.length();
        int length2 = t.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[length1][length2] == length1;
    }

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("abc", "ahbgdc"));
    }
}
