package algorithm;

import java.util.Random;

/**
 * @author zjn
 **/
public class ShuffleAnArray {
    int[] nums;
    int n;
    Random random = new Random();
    public ShuffleAnArray(int[] _nums) {
        nums = _nums;
        n = nums.length;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] ans = nums.clone();
        for (int i = 0; i < n; i++) {
            swap(ans, i, i + random.nextInt(n - i));
        }
        return ans;
    }

    private void swap(int[] arr, int i, int j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}
