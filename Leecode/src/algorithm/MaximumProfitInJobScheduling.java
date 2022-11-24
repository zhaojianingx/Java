package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zjn
 **/
public class MaximumProfitInJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(new int[]{startTime[i], endTime[i], profit[i]});
        list.sort((a, b) -> a[1] - b[1]);
        int[] f = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            int[] info = list.get(i - 1);
            int a = info[0], b = info[1], c = info[2];
            f[i] = Math.max(f[i - 1], c);
            int l = 0, r = i - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (list.get(mid)[1] <= a) l = mid;
                else r = mid - 1;
            }
            if (list.get(r)[1] <= a) f[i] = Math.max(f[i], f[r + 1] + c);
        }
        return f[n];
    }
}
