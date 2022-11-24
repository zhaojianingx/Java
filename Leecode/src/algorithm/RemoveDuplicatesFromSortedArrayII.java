package algorithm;

/**
 * @author zjn
 **/
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        // 最大重复次数两次
        int maxRepeat = 2;
        int slow = maxRepeat - 1;
        for (int fast = maxRepeat; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - maxRepeat + 1]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesFromSortedArrayII().removeDuplicates(new int[]{0}));
    }
}
