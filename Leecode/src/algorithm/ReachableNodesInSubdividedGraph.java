package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zjn
 **/
public class ReachableNodesInSubdividedGraph {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<int[]>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], cnt = e[2];
            g[u].add(new int[]{v, cnt + 1});
            g[v].add(new int[]{u, cnt + 1}); // 建图
        }

        int[] dist = dijkstra(g, 0); // 从0出发的最短路

        int ans = 0;
        for (int d : dist)
            if (d <= maxMoves)  // 这个点可以在maxMoves步到达
                ++ans;
        for (var e : edges) {
            int u = e[0], v= e[1], cnt = e[2];
            int a = Math.max(maxMoves - dist[u], 0);
            int b = Math.max(maxMoves - dist[v], 0);
            ans += Math.min(a + b, cnt); //这条边上可以到达的节点数
        }
        return ans;
    }

    // 返回从start到每个点的最短路
    private int[] dijkstra(List<int[]>[] g, int start) {
        int[] dist = new int[g.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        var pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        while (!pq.isEmpty()) {
            var p = pq.poll();
            int x = p[0], d = p[1];
            if (d > dist[x]) continue;
            for (var e : g[x]) {
                int y = e[0];
                int newDist = d + e[1];
                if (newDist < dist[y]) {
                    dist[y] = newDist;
                    pq.offer(new int[]{y, newDist});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        System.out.println(new ReachableNodesInSubdividedGraph().reachableNodes(new int[][]{{0, 1, 10}, {0, 2, 1}, {1, 2, 2}}, 6, 3));
    }
}
