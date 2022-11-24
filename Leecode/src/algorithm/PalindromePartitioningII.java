package algorithm;

/**
 * @author zjn
 **/
public class PalindromePartitioningII {
    public int minCut(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        int len = s.length();
        boolean[][] isPalindromic = new boolean[len][len];
        // 从下到上，从左到右
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        isPalindromic[i][j] = true;
                    } else {
                        isPalindromic[i][j] = isPalindromic[i + 1][j - 1];
                    }
                } else {
                    isPalindromic[i][j] = false;
                }
            }
        }
        // dp[i]表示[0 ... i]的最小分割次数
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = i;
        }

        for (int i = 1; i < len; i++) {
            if (isPalindromic[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (isPalindromic[j + 1][i]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioningII().minCut("aab"));
    }
}
