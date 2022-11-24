package algorithm;

/**
 * @author zjn
 **/
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long)Math.sqrt(c);
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(5));
    }
}
