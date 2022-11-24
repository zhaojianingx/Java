package algorithm;

import java.util.Arrays;

/**
 * @author zjn
 **/
public class SquaresOfaSortedArray {
    public int[] sortedSquares(int[] nums) {
        // 双指针
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int index = nums.length - 1;
        // 左闭右闭区间
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index--] = nums[left] * nums[left];
                left++;
            } else {
                result[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SquaresOfaSortedArray().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}
