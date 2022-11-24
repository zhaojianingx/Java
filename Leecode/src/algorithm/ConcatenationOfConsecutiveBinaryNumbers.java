package algorithm;

/**
 * @author zjn
 **/
public class ConcatenationOfConsecutiveBinaryNumbers {
    private static final int MOD = 1000000007;

    public int concatenatedBinary(int n) {
        long res = 0, shift = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                // 说明是2的幂，则进位
                shift++;
            }
            res = ((res << shift) + i) % MOD;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new ConcatenationOfConsecutiveBinaryNumbers().concatenatedBinary(3));
    }
}
