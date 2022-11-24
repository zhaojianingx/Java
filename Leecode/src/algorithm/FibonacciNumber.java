package algorithm;

/**
 * @author zjn
 **/
public class FibonacciNumber {
    public int fib(int n) {
        if (n <= 1) return n;
        // dp[i]表示第i个数的斐波那契数值
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int index = 2; index <= n; index++) {
            dp[index] = dp[index - 1] + dp[index - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new FibonacciNumber().fib(10));
    }
}
