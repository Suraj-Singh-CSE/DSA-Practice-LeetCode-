import java.util.*;

class Solution {
    private static final int[][] DIRECTIONS = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[m][n];

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int row = current[0];
            int col = current[1];
            int cost = current[2];

            if (visited[row][col]) continue;
            visited[row][col] = true;

            if (row == m - 1 && col == n - 1) return cost;

            for (int dir = 0; dir < 4; dir++) {
                int newRow = row + DIRECTIONS[dir][0];
                int newCol = col + DIRECTIONS[dir][1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    int newCost = cost + (grid[row][col] == dir + 1 ? 0 : 1);
                    pq.offer(new int[]{newRow, newCol, newCost});
                }
            }
        }

        return -1;
    }
}
