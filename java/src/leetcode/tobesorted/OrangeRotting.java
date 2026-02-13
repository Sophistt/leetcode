package leetcode.tobesorted;

import java.util.Queue;
import java.util.LinkedList;

public class OrangeRotting {
    public int orangesRotting(int[][] grid) {
        return bfs(grid);
    }

    public int bfs(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        // 将所有腐烂的橘子加入到队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int count = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 四个路径
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < m && x >= 0 && y < n && y >= 0 && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.add(new int[]{x, y});
                    }
                }
            }
            count++;
        }
        if (!isRotted(grid)) return -1;
        return count == 0 ? 0 : count - 1;
    }

    public boolean isRotted(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
