package algorithm;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author zjn
 **/
public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        if (k % 2 == 1) nums[len - 1] = -nums[len - 1];
        return Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        System.out.println(new MaximizeSumOfArrayAfterKNegations().largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
    }
}
