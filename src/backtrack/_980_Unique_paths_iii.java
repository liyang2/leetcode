package backtrack;

public class _980_Unique_paths_iii {
    int m, n;
    public int uniquePathsIII(int[][] grid) {
        int obstacles = 0;
        m = grid.length;
        n = grid[0].length;
        int[] start = new int[2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                } else if (grid[i][j] == -1) {
                    obstacles++;
                }
            }
        }

        int nonObstacles = m * n - obstacles;
        return backtrack(grid, start[0], start[1], nonObstacles);
    }

    final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int backtrack(int[][] grid, int i, int j, int nonObstacles) {
        int res = 0;
        if (nonObstacles == 1 && grid[i][j] == 2) {
            return 1;
        }
        int original = grid[i][j];
        grid[i][j] = -2; // -2 means visited

        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (nextI < 0 || nextI == m || nextJ < 0 || nextJ == n
                    || grid[nextI][nextJ] < 0) {
                continue;
            }
            res += backtrack(grid, nextI, nextJ, nonObstacles - 1);
        }
        grid[i][j] = original;
        return res;
    }
}
