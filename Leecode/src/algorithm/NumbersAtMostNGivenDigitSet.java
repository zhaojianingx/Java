package algorithm;

import java.util.Arrays;

/**
 * @author zjn
 **/
public class NumbersAtMostNGivenDigitSet {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        // 存放在digits中小于0-9数字的个数
        int[] lessThanPerDigit = new int[10];
        int[] digitArr = new int[10];
        for (int i = 0; i < digits.length; i++) {
            int num = Integer.parseInt(digits[i]);
            Arrays.fill(lessThanPerDigit, num + 1, 10, i + 1);
            digitArr[num] = 1;
        }
        // 计算n的长度
        int len = 0;
        // 把n的每个位数都放入数组
        int[] n2Arr = new int[10];
        while (n != 0) {
            n2Arr[len++] = n % 10;
            n = n / 10;
        }
        int ans = 0;
        // 全都是小于n的位数的个数，直接相加即可
        for (int i = 1; i < len; i++) {
            ans += Math.pow(digits.length, i);
        }
        // 小于第一位的全部可能
        ans += lessThanPerDigit[n2Arr[len - 1]] * (int) Math.pow(digits.length, len - 1);
        for (int i = len - 1; i >= 0; i--) {
            // 是否存在该数字
            if (digitArr[n2Arr[i]] == 1) {
                ans = i == 0 ? ans + 1 : ans + lessThanPerDigit[n2Arr[i - 1]] * (int) Math.pow(digits.length, i - 1);
            } else {
                // 计算完毕 直接退出即可
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NumbersAtMostNGivenDigitSet().atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 100));
    }
}
