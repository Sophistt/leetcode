package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class FindShortestCycle {
    public int findShortestCycle(int n, int[][] edges) {
        List<Integer>[] adj = createGraph(n, edges);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) // 枚举每个起点跑 BFS
            ans = Math.min(ans, bfs(adj, i));
        return ans < Integer.MAX_VALUE ? ans : -1;
    }

    public List<Integer>[] createGraph(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];
        Arrays.setAll(adj, i -> new ArrayList<Integer>());
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        return adj;
    }

    public int bfs(List<Integer>[] graph, int start) {
        int ans = Integer.MAX_VALUE;
        int[] dist = new int[graph.length];
        Arrays.fill(dist, -1);
        dist[start] = 0;

        var queue = new LinkedList<int[]>();
        queue.add(new int[]{start, -1});
        while (!queue.isEmpty()) {
            var cur = queue.poll();
            int pos = cur[0], fa = cur[1];
            for (int next : graph[pos]) {
                if (dist[next] == -1) { // 只有第一次遇到的节点才会加入到队列。所以不用额外使用 visited 数组
                    dist[next] = dist[pos] + 1; // 算出距离等同于 visited = True
                    queue.add(new int[]{next, pos});
                } else if (next != fa) {
                    ans = Math.min(ans, dist[pos] + dist[next] + 1);
                }
            }
        }
        return ans;
    }
}
