package algorithm;

/**
 * @author zjn
 **/
public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] dp = new int[n2 + 1];
        for (int i = 1; i <= n1; i++) {
            int pre = dp[0];

            for (int j = 1; j <= n2; j++) {
                int cur = dp[j];
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = pre + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }

                pre = cur;
            }
        }
        return dp[n2];
    }

    public static void main(String[] args) {
        System.out.println(new UncrossedLines().maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
    }
}
