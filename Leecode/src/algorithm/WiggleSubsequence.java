package algorithm;

/**
 * @author zjn
 **/
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        // 当前差值
        int curDiff = 0;
        // 上一个差值
        int preDiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            // 得到当前差值
            curDiff = nums[i] - nums[i - 1];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >=0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new WiggleSubsequence().wiggleMaxLength(new int[]{1, 7, 4, 4, 9, 2, 5}));
    }
}
