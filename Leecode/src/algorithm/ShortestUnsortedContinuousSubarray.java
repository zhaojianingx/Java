package algorithm;

/**
 * @author zjn
 **/
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int min = nums[len - 1];
        int max = nums[0];
        int begin = 0, end = -1;
        //遍历
        for (int i = 0; i < len; i++) {
            if (nums[i] < max) { // 从左到右维持最大值，寻找右边界end
                end = i;
            } else {
                max = nums[i];
            }

            if (nums[len - i - 1] > min) { // 从右到左维持最小值，寻找左边界begin
                begin = len - i - 1;
            } else {
                min = nums[len - i - 1];
            }
        }
        return end - begin + 1;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{2, 6 ,4 ,8, 10, 9, 15}));
    }
}
