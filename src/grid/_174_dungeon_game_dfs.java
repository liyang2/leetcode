package grid;

// got TLE
public class _174_dungeon_game_dfs {
    int m, n;
    int[][] grid;
    boolean[][] visited;
    int maxLowest = Integer.MIN_VALUE;

    public int calculateMinimumHP(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        dfs(0, 0, 0, 0);
        if(maxLowest<=0) {
            return -maxLowest+1;
        } else {
            return 1;
        }
    }

    void dfs(int i, int j, int health, int lowestHealth) {
        if(i == m || j == n) return;
        visited[i][j] = true;
        health += grid[i][j];
        lowestHealth = Math.min(lowestHealth, health);
        if(i == m-1 && j == n-1) {
            maxLowest = Math.max(maxLowest, lowestHealth);
        }

        dfs(i+1, j, health, lowestHealth);
        dfs(i,j+1, health, lowestHealth);

        visited[i][j] = false;
    }
}
