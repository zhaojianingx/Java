package algorithm;

import java.util.Arrays;

/**
 * @author zjn
 **/
public class BuildArrayFromPermutation {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] + n * (nums[nums[i]] % n);
        }
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] / n;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new BuildArrayFromPermutation().buildArray(new int[]{0, 2, 1, 5, 3, 4})));
    }
}
