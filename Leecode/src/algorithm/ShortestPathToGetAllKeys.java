package algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zjn
 **/
public class ShortestPathToGetAllKeys {
    // 控制人物可以移动的方向
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestPathAllKeys(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        int keyNum = 0; // 钥匙数量
        List<int[]> list = new LinkedList<>();
        // 初始化地图信息
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') { // 起点
                    list.add(new int[]{i, j, 0});
                }
                if ('a' <= c && c <= 'z') {
                    keyNum += 1;
                }
            }
        }
        // 在每一个区域，收集到（不同数目不同类别）的钥匙，所需的步长
        int[][][] dist = new int[n][m][1 << keyNum];
        // 从地图起点，往各个方向寻找钥匙
        while (list.size() != 0) {
            int[] arr = list.remove(0);
            int x = arr[0];
            int y = arr[1];
            int s = arr[2];
            int step = dist[x][y][s];
            for (int[] dir : dirs) {
                int xx = x + dir[0];
                int yy = y + dir[1];
                int ss = s;
                if (xx < 0 || n <= xx || yy < 0 || m <= yy) {
                    continue;
                }
                char c = grid[xx].charAt(yy);
                if (c == '#') {
                    continue;
                }
                if ('A' <= c && c <= 'Z') {
                    if ((s >> (c - 'A') & 1) != 1) {
                        continue;
                    }
                }
                if ('a' <= c && c <= 'z') {
                    ss |= 1 << (c - 'a');
                }
                if (ss == (1 << keyNum) - 1) {
                    return step + 1;
                }
                // 如果该地没走过，或者走到此处比曾经用过的步数更少
                if (dist[xx][yy][ss] == 0 || step + 1 < dist[xx][yy][ss]) {
                    dist[xx][yy][ss] = step + 1;
                    list.add(new int[]{xx, yy, ss});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestPathToGetAllKeys().shortestPathAllKeys(new String[]{"@.a.#","###.#","b.A.B"}));
    }
}
