package algorithm;

/**
 * @author zjn
 **/
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int[] dp = new int[2];
        // 0代表持有，1代表卖出
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i <= prices.length; i++) {
            dp[0] = Math.max(dp[0], -prices[i - 1]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i - 1]);
        }
        return dp[1];
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
