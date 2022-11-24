package algorithm;

import java.util.Arrays;

/**
 * @author zjn
 **/
public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (x, y) -> Integer.compare(x[0], y[0]));
        int count = 1;
        // 重叠气球的最小右边界
        int leftMostRightBound = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > leftMostRightBound) {
                // 增加一次射击
                count++;
                leftMostRightBound = points[i][1];
            } else {
                leftMostRightBound = Math.min(leftMostRightBound, points[i][1]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }
}
