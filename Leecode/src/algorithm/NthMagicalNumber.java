package algorithm;

/**
 * @author zjn
 **/
public class NthMagicalNumber {
    private static final long MOD = (long) 1e9 + 7;

    public int nthMagicalNumber(int n, int a, int b) {
        long lcm = a / gcd(a, b) * b;
        long left = 0, right = (long) Math.max(a, b) * n;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid / a + mid /b - mid / lcm >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) (right % MOD);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(new NthMagicalNumber().nthMagicalNumber(4, 2, 3));
    }
}
