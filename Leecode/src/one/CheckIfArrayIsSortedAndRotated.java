package one;

/**
 * @author zjn
 **/
public class CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        int cnt = 0;
        for (int i = 0, n = nums.length; i < n; ++i) {
            if (nums[i] > nums[(i + 1) % n]) {
                ++cnt;
            }
        }
        return cnt <= 1;
    }

    public static void main(String[] args) {
        System.out.println(new CheckIfArrayIsSortedAndRotated().check(new int[]{3, 4, 5, 1, 2}));
    }
}
