package algorithm;

import java.util.Arrays;

/**
 * @author zjn
 **/
public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        // dp[i]表示i之前（包括i）最长递增子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        // count[i]表示以nums[i]为结尾的字符串，最长递增子序列的个数
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);

        int maxCount = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 ==dp[i]) {
                        count[i] += count[j];
                    }
                }
                if (dp[i] > maxCount) maxCount = dp[i];
            }
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxCount == dp[i]) result += count[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }
}
