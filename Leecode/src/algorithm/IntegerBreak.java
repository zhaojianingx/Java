package algorithm;

/**
 * @author zjn
 **/
public class IntegerBreak {
    public int integerBreak(int n) {
        // dp[i]表示分拆数字i，可以得到的最大乘积为dp[i]
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(3));
    }
}
