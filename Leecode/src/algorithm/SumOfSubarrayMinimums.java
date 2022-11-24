package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zjn
 **/
public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        int MOD = (int)1e9 + 7;
        int n = arr.length, ans = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int r = 0; r <= n; r++) {
            int t = r < n ? arr[r] : 0;
            while (!deque.isEmpty() && arr[deque.peekLast()] >= t) {
                int cur = deque.pollLast();
                int l = deque.isEmpty() ? -1 : deque.peekLast();
                int a = cur - l, b = r - cur;
                ans += a * 1L * b % MOD * arr[cur] % MOD;
                ans %= MOD;
            }
            deque.addLast(r);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfSubarrayMinimums().sumSubarrayMins(new int[]{1, 2, 3, 2, 4}));
    }
}
