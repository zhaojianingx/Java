package one;

/**
 * @author zjn
 **/
public class SqrtX {
    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            long r = (long) mid * mid;
            if (r == x) {
                return (int) mid;
            } else if (r > x) {
                right = mid - 1;
            } else if (r < x) {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        System.out.println(new SqrtX().mySqrt(2147395599));
    }
}
