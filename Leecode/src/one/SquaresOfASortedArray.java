package one;

import java.util.Arrays;

/**
 * @author zjn
 **/
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int index = right;
        int[] res = new int[nums.length];
        while (left <= right) {
            int a = nums[left] * nums[left], b = nums[right] * nums[right];
            if (a <= b) {
                res[index--] = b;
                right--;
            } else {
                res[index--] = a;
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SquaresOfASortedArray().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}
