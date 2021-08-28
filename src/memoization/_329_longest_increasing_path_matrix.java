package memoization;

public class _329_longest_increasing_path_matrix {
    boolean[][] used;
    int[][] matrix;
    int[][] dirs = {{0, 1}, {0, -1}, {1,0}, {-1,0}};
    int m,n;
    int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        used = new boolean[m][n];
        memo = new int[m][n];
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res = Math.max(res, dfs(i, j, -1));
            }
        }
        return res;
    }


    // dfs() returns the longest increasing path's length starting from (i, j)
    int dfs(int i, int j, int prev) {
        if(i < 0 || j < 0 || i >= m || j >= n || used[i][j] ||
                matrix[i][j] <= prev) return 0;
        if(memo[i][j] != 0) return memo[i][j];
        used[i][j] = true;
        int res = 0;

        for(int[] dir: dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            res = Math.max(res, 1+dfs(newI, newJ, matrix[i][j]));
        }
        used[i][j] = false;
        memo[i][j] = res;
        return res;
    }
}
