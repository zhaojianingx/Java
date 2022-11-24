package algorithm;

/**
 * @author zjn
 **/
public class BestTimeToBuyAndSellStockWithTransactionFee {
    // 贪心算法
    public int maxProfit(int[] prices, int fee) {
        int buy = prices[0] + fee;
        int sum = 0;
        for (int p : prices) {
            if (p + fee < buy) {
                buy = p + fee;
            } else if (p > buy) {
                sum += p - buy;
                buy = p;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockWithTransactionFee().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
