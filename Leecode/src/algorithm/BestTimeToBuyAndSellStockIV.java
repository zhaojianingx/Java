package algorithm;

/**
 * @author zjn
 **/
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        if (k == 0) {
            return 0;
        }

        int[] dp = new int[2 * k];

        for (int i = 0; i < dp.length / 2; i++) {
            dp[i * 2] = -prices[0];
        }
        for (int i = 1; i <= prices.length; i++) {
            dp[0] = Math.max(dp[0], -prices[i - 1]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i - 1]);
            for (int j = 2; j < dp.length; j += 2) {
                dp[j] = Math.max(dp[j], dp[j - 1] - prices[i - 1]);
                dp[j + 1] = Math.max(dp[j + 1], dp[j] + prices[i - 1]);
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit(2, new int[]{2, 4, 1}));
    }
}
