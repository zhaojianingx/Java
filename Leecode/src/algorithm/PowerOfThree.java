package algorithm;

/**
 * @author zjn
 **/
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfThree().isPowerOfThree(243));
    }
}
