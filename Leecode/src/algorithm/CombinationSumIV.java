package algorithm;

/**
 * @author zjn
 **/
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        // dp[i]表示凑成目标正整数为i的排列个数
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumIV().combinationSum4(new int[]{1, 2, 3}, 4));
    }
}
