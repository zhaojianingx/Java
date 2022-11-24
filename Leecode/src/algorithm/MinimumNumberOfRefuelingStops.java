package algorithm;

import java.util.PriorityQueue;

/**
 * @author zjn
 **/
public class MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int ans = 0, prev = 0, fuel = startFuel;
        int n = stations.length;
        for (int i = 0; i <= n; i++) {
            int curr = i < n ? stations[i][0] : target;
            fuel -= curr - prev;
            while (fuel < 0 && !queue.isEmpty()) {
                fuel += queue.poll();
                ans++;
            }
            if (fuel < 0) {
                return -1;
            }
            if (i < n) {
                queue.offer(stations[i][1]);
                prev = curr;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfRefuelingStops().minRefuelStops(1, 1, new int[][]{}));
    }
}
