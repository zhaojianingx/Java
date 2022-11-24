package algorithm;

/**
 * @author zjn
 **/
public class GlobalAndLocalInversions {
    public boolean isIdealPermutation(int[] nums) {
        int max = nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < max) return false;
            max = Math.max(max, nums[i - 1]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new GlobalAndLocalInversions().isIdealPermutation(new int[]{0, 2, 3, 4, 1}));
    }
}
