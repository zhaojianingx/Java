package algorithm;

/**
 * @author zjn
 **/
public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        if (n > 1) {
            while (n % 4 == 0) {
                n /= 4;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfFour().isPowerOfFour(32));
    }
}
