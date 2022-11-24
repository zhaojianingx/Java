package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zjn
 **/
public class ShortestBridge {
    int[][] grid, coordinates = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    Deque<int[]> edges;
    public int shortestBridge(int[][] grid) {
        int result = 0;
        boolean findIsland = false;
        edges = new ArrayDeque<>();
        this.grid = grid;
        for (int i = 0; !findIsland && i < grid.length; i++) {
            for (int j = 0; !findIsland && j < grid[0].length; j++) {
                if (findIsland = (grid[i][j] == 1)) markIsland(i, j);
            }
        }

        while (!edges.isEmpty()) {
            result++;
            int num = edges.size();
            for (int i = 0; i < num; i++) {
                int[] edge = edges.removeFirst();
                for (int[] c : coordinates) {
                    int nextx = edge[0] + c[0], nexty = edge[1] + c[1];
                    if (isLegal(nextx, nexty) && grid[nextx][nexty] == 0) {
                        edges.addLast(new int[]{nextx, nexty});
                        grid[nextx][nexty] = 2;
                    } else if (isLegal(nextx, nexty) && grid[nextx][nexty] == 1) return result;
                }
            }
        }
        return result;
    }

    private void markIsland(int row, int column) {
        if (!isLegal(row, column) || grid[row][column] == 2) return;
        if (grid[row][column] == 0) {
            grid[row][column] = 2;
            edges.addLast(new int[]{row, column});
            return;
        }
        grid[row][column] = 2;
        for (int[] c : coordinates) markIsland(row + c[0], column + c[1]);
    }

    private boolean isLegal(int row, int column) {
        return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
    }
}
