package algorithm;

import java.util.UnknownFormatConversionException;

/**
 * @author zjn
 **/
public class NumberOfSubarraysWithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length, ans = 0, a = -1, b = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > right) a = i;
            if (nums[i] >= left) b = i;
            ans += b - a;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfSubarraysWithBoundedMaximum().numSubarrayBoundedMax(new int[]{2, 9, 2, 5, 6}, 2, 8));
    }
}
