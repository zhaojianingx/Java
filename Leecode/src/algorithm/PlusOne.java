package algorithm;

import java.util.Arrays;

/**
 * @author zjn
 **/
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i]++ < 9) {
                return digits;
            }
            digits[i] = 0;
        }
        int[] arr = new int[n + 1];
        arr[0] = 1;
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{9, 9, 9})));
    }
}
