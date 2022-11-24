package algorithm;

import java.util.Arrays;

/**
 * @author zjn
 **/
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        // dp[i]：以下标i为结尾的数组的连续递增的子序列长度为dp[i]
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            res = Math.max(res, dp[i + 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestContinuousIncreasingSubsequence().findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    }
}
