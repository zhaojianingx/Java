package algorithm;

/**
 * @author zjn
 **/
public class SignOfTheProductOfAnArray {
    public int arraySign(int[] nums) {
        int ans = 1;
        for (int x : nums) {
            if (x == 0) return 0;
            if (x < 0) ans *= -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SignOfTheProductOfAnArray().arraySign(new int[]{1, 2}));
    }
}
