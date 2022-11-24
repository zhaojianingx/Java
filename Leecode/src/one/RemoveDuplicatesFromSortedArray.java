package one;

/**
 * @author zjn
 **/
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int low = 1, high;
        for (high = 1; high < nums.length; high++) {
            if (nums[high] != nums[high - 1]) {
                nums[low] = nums[high];
                low++;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(new int[] {1, 1, 2}));
    }
}
