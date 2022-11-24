package algorithm;

import java.util.Arrays;

/**
 * @author zjn
 **/
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        // 定义双指针
        int oddPoint = 1, evenPoint = 0;
        // 开始移动交换，最后一层必然为相互交换后再移动或者相同直接移动
        while (oddPoint < nums.length && evenPoint < nums.length) {
            // 进行判断
            if (nums[oddPoint] % 2 == 0 && nums[evenPoint] % 2 == 1) {
                int temp = 0;
                temp = nums[oddPoint];
                nums[oddPoint] = nums[evenPoint];
                nums[evenPoint] = temp;
                oddPoint += 2;
                evenPoint += 2;
            } else if (nums[oddPoint] % 2 == 0 && nums[evenPoint] % 2 == 0) {
                evenPoint += 2;
            } else if (nums[oddPoint] % 2 == 1 && nums[evenPoint] % 2 == 1) {
                oddPoint += 2;
            } else {
                oddPoint += 2;
                evenPoint += 2;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortArrayByParityII().sortArrayByParityII(new int[]{4, 2, 5, 7, 9, 9, 10, 10})));
    }
}
