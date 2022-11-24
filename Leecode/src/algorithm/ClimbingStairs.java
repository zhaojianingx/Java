package algorithm;

/**
 * @author zjn
 **/
public class ClimbingStairs {
    public int climbStairs1(int n) {
        // 爬到第i层楼梯，有dp[i]种方法
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 2;
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        int[] weight = {1, 2};
        dp[0] = 1;

        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j < weight.length; j++) {
                if (i >= weight[j]) {
                    dp[i] += dp[i - weight[j]];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs1(1));
    }
}
