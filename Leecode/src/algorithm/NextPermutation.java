package algorithm;

/**
 * @author zjn
 **/
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int pivot = indexOFLastPeak(nums) - 1;
        if (pivot != -1) {
            int nextPrefix = lastIndexOfGreater(nums, nums[pivot]);
            swap(nums, pivot, nextPrefix);
        }
        reverseSuffix(nums, pivot + 1);
    }

    private void reverseSuffix(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int lastIndexOfGreater(int[] nums, int threshold) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (threshold < nums[i]) return i;
        }
        return -1;
    }

    private int indexOFLastPeak(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new NextPermutation().nextPermutation(new int[]{3, 2, 1});
    }
}
