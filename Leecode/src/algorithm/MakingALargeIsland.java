package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zjn
 **/
public class MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        int value = 2; // 岛屿编号
        Map<Integer, Integer> islandAreas = new HashMap<>(); // 岛屿编号 -> 岛屿面积

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int a = area(grid, r, c, value);
                    islandAreas.put(value, a);
                    value++;
                }
            }
        }

        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                // 依次尝试填海
                int ta = thisArea(grid, r, c, islandAreas);
                res = Math.max(res, ta);
            }
        }
        return res;
    }

    // 把（r, c）填海之后，最大的岛屿面积
    private int thisArea(int[][] grid, int r, int c, Map<Integer, Integer> islandAreas) {
        if (grid[r][c] != 0) {
            return islandAreas.get(grid[r][c]);
        }
        int res = 0;
        Set<Integer> set = new HashSet<>();
        if (inArea(grid, r - 1, c) && grid[r - 1][c] > 0) {
            set.add(grid[r - 1][c]);
        }
        if (inArea(grid, r + 1, c) && grid[r + 1][c] > 0) {
            set.add(grid[r + 1][c]);
        }
        if (inArea(grid, r, c - 1) && grid[r][c - 1] > 0) {
            set.add(grid[r][c - 1]);
        }
        if (inArea(grid, r, c + 1) && grid[r][c + 1] > 0) {
            set.add(grid[r][c + 1]);
        }
        for (int integer : set) {
            res += islandAreas.get(integer);
        }
        return res + 1;
    }

    // value表示当前岛屿编号
    private int area(int[][] grid, int r, int c, int value) {
        if (!inArea(grid, r, c)) {
            return 0;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = value;

        return 1
                + area(grid, r - 1, c, value)
                + area(grid, r + 1, c, value)
                + area(grid, r, c - 1, value)
                + area(grid, r, c + 1, value);
    }

    private boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
