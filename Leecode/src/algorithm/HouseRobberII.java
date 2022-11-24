package algorithm;

/**
 * @author zjn
 **/
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        return Math.max(robAction(nums, 0, len - 1), robAction(nums, 1, len));
    }

    private int robAction(int[] nums, int start, int end) {
        int x = 0, y = 0, z = 0;
        for (int i = start; i < end; i++) {
            y = z;
            z = Math.max(y, x + nums[i]);
            x = y;
        }
        return z;
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobberII().rob(new int[]{2, 3, 2}));
    }
}
