package algorithm;

/**
 * @author zjn
 **/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[]{1, 2, 3, 1, 3}));
    }
}
