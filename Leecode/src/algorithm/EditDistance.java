package algorithm;

/**
 * @author zjn
 **/
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp[i][j]表示以下标i - 1为结尾的字符串word1，和以下标j - 1为结尾的字符串word2，最近编辑距离
        int[][] dp = new int[m + 1][n + 1];
        // 初始化
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("horse", "ros"));
    }
}
