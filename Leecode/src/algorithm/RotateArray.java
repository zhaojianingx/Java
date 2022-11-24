package algorithm;

import java.util.Arrays;

/**
 * @author zjn
 **/
public class RotateArray {
    public int[] rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n -1);
        reverse(nums, 0, k -1);
        reverse(nums, k, n -1);
        return nums;
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RotateArray().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
    }
}
