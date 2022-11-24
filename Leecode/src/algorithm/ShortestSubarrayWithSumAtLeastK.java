package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zjn
 **/
public class ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] s = new long[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int ans = n + 1;
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && s[i] - s[deque.peek()] >= k) {
                ans = Math.min(ans, i - deque.pop());
            }
            while (!deque.isEmpty() && s[deque.peekLast()] >= s[i]) {
                deque.pollLast();
            }
            deque.offer(i);
        }
        return ans > n ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestSubarrayWithSumAtLeastK().shortestSubarray(new int[]{2, -1, 2}, 3));
    }
}
