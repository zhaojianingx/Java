package algorithm;

/**
 * @author zjn
 **/
public class BestTimeToBuyAndSellStockWithCoolDown {
    public int maxProfit(int[] prices) {
        int[] dp = new int[4];

        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i <= prices.length; i++) {
            int temp1 = dp[0];
            int temp2 = dp[2];
            // 买入股票状态（今天买入股票，或者是之前就买入了股票然后没有操作）
            dp[0] = Math.max(dp[0], Math.max(dp[3], dp[1]) - prices[i - 1]);
            // 两天前就卖出了股票，度过了冷冻期，一直没操作，今天保持卖出股票状态
            dp[1] = Math.max(dp[1], dp[3]);
            // 今天卖出股票
            dp[2] = temp1 + prices[i - 1];
            // 今天为冷冻期，但冷冻期不可持续，只有一天
            dp[3] = temp2;
        }
        return Math.max(dp[3], Math.max(dp[1], dp[2]));
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockWithCoolDown().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
