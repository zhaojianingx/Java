package algorithm;

/**
 * @author zjn
 **/
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        // 快慢指针
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != 0) {
                int temp = nums[slowIndex];
                nums[slowIndex]= nums[fastIndex];
                nums[fastIndex] = temp;
                slowIndex++;
            }
        }
    }

    public static void main(String[] args) {
        new MoveZeroes().moveZeroes(new int[]{1});
    }
}
