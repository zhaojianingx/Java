package algorithm;

/**
 * @author zjn
 **/
public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        // 双指针
        int left = 0;
        int right = arr.length - 1;
        // 注意防止指针越界
        while (left + 1 < arr.length && arr[left] < arr[left + 1]) {
            left++;
        }
        while (right > 0 && arr[right] < arr[right - 1]) {
            right--;
        }
        // 如果left或者right都在起始位置，说明不是山峰
        return left == right && left != 0 && right != arr.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(new ValidMountainArray().validMountainArray(new int[]{2, 5, 3}));
    }
}
