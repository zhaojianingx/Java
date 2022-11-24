package algorithm;

/**
 * @author zjn
 **/
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[] dp = new int[n2 + 1];
        for (int i = 1; i <= n1; i++) {
            int pre = dp[0];
            for (int j = 1; j <= n2; j++) {
                int cur = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = pre + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }

                pre = cur;
            }
        }
        return dp[n2];
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("adb", "abd"));
    }
}
