package one;


import jdk.swing.interop.LightweightFrameWrapper;

/**
 * @author zjn
 **/
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            long r = (long) mid * mid;
            if (r == num) {
                return true;
            } else if (r > num) {
                right = mid - 1;
            } else if (r < num) {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(14));
    }
}
