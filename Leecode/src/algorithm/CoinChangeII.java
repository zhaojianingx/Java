package algorithm;

/**
 * @author zjn
 **/
public class CoinChangeII {
    public int change(int amount, int[] coins) {
        // dp[j]表示凑成总金额为j的货币组合数
        int[] dp = new int[amount + 1];
        // 初始化
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChangeII().change(5, new int[]{1, 2, 5}));
    }
}
