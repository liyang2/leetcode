package graph;
import java.util.*;
public class _1730_shortest_path_to_get_food {
    public int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int steps = 1;
        Queue<int[]> q = new LinkedList<>();
        for(int i= 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '*') {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    break;
                }
            }
        }
        int[][] dirs =  {{0, 1}, {0, -1}, {1,0}, {-1, 0}};
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] point = q.poll();
                for(int[] dir: dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 'X'
                            || visited[x][y])
                        continue;
                    if(grid[x][y] == '#') {
                        return steps;
                    }
                    q.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            steps++;
        }
        return -1;
    }
}
