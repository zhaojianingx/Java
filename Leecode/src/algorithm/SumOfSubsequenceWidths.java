package algorithm;

import java.util.Arrays;

/**
 * @author zjn
 **/
public class SumOfSubsequenceWidths {
    private static final int MOD = (int) 1e9 + 7;

    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; ++i) {
            pow2[i] = pow2[i - 1] * 2 % MOD;
        }
        long ans = 0L;
        for (int i = 0; i < n; ++i) {
            ans += (long) (pow2[i] - pow2[n - 1 - i]) * nums[i];
        }
        return (int) (ans % MOD + MOD) % MOD;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfSubsequenceWidths().sumSubseqWidths(new int[]{2, 1, 3}));
    }
}
