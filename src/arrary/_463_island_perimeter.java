package arrary;

public class _463_island_perimeter {
    int m, n;
    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0;j < n; j++) {
                res += cellPerimeter(grid, i, j);
            }
        }
        return res;
    }
    int cellPerimeter(int[][] grid, int i, int j) {
        int res = 0;
        if(grid[i][j] == 0) return 0;

        if(i == 0 || grid[i-1][j] == 0)
            res++;
        if(i == m-1 || grid[i+1][j] == 0)
            res++;
        if(j == 0 || grid[i][j-1] == 0)
            res++;
        if(j == n-1 || grid[i][j+1] == 0)
            res++;
        return res;
    }
}
