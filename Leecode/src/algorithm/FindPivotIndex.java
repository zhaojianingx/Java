package algorithm;

/**
 * @author zjn
 **/
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            rightSum = sum - leftSum + nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1; // 不存在
    }

    public static void main(String[] args) {
        System.out.println(new FindPivotIndex().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}
