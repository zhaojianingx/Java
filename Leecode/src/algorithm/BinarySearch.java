package algorithm;

/**
 * @author zjn
 **/
public class BinarySearch {
    public int search1(int[] nums, int target) {
        // 左闭右闭区间
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        // 左闭右开区间
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (target < nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().search2(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }
}
