package one;

import java.util.Arrays;

/**
 * @author zjn
 **/
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target);
        if (index == -1) return new int[] {-1, -1};

        // nums中存在target，左右滑动指针确定符合题意区间
        int left = index, right = index;
        //向左滑动，找左边界
        while (left >= 1 && nums[left] == nums[left - 1]) {
            left--;
        }
        //向右滑动，找右边界
        while (right + 1 <= nums.length - 1 && nums[right] == nums[right + 1]) {
            right++;
        }
        return new int[] {left, right};
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
