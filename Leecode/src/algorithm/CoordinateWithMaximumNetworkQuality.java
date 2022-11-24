package algorithm;

import java.util.Arrays;

/**
 * @author zjn
 **/
public class CoordinateWithMaximumNetworkQuality {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int xMax = Integer.MIN_VALUE, yMax = Integer.MIN_VALUE;
        for (int[]tower : towers) {
            int x = tower[0], y = tower[1];
            xMax = Math.max(xMax, x);
            yMax = Math.max(yMax, y);
        }
        int cx = 0, cy = 0;
        int maxQuality = 0;
        for (int x = 0; x <= xMax; x++) {
            for (int y = 0; y <= yMax; y++) {
                int[] coordinate = {x, y};
                int quality = 0;
                for (int[] tower : towers) {
                    int squareDistance = getSquareDistance(coordinate, tower);
                    if (squareDistance <= radius * radius) {
                        double distance = Math.sqrt(squareDistance);
                        quality += (int) Math.floor(tower[2] / (1 + distance));
                    }
                }
                if (quality > maxQuality) {
                    cx = x;
                    cy = y;
                    maxQuality = quality;
                }
            }
        }
        return new int[]{cx, cy};
    }

    private int getSquareDistance(int[] coordinate, int[] tower) {
        return (tower[0] - coordinate[0]) * (tower[0] - coordinate[0]) + (tower[1] - coordinate[1]) * (tower[1] - coordinate[1]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CoordinateWithMaximumNetworkQuality().bestCoordinate(new int[][]{{1, 2, 4}, {2, 1, 7}, {3, 1, 9}}, 2)));
    }
}
