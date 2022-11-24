package algorithm;

/**
 * @author zjn
 **/
public class MaximumAscendingSubarraySum {
    public int maxAscendingSum(int[] nums) {
        int ans = 0, t= 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                t += nums[i];
                ans = Math.max(ans, t);
            } else {
                t = nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumAscendingSubarraySum().maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
    }
}
