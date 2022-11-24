package algorithm;

/**
 * @author zjn
 **/
public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        // dp[j]表示容量为i的背包，最多可以背dp[j]这么重的石头
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }
        int target = sum >> 1;
        // 初始化dp数组
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - 2 * dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new LastStoneWeightII().lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
    }
}
