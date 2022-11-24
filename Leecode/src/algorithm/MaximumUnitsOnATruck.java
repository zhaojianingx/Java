package algorithm;

import java.util.Arrays;

/**
 * @author zjn
 **/
public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n = boxTypes.length, ans = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        for (int i = 0, cnt = 0; i < n && cnt < truckSize; i++) {
            int a = boxTypes[i][0], b = boxTypes[i][1], c = Math.min(a, truckSize - cnt);
            cnt += c;
            ans += c * b;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumUnitsOnATruck().maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4));
    }
}
