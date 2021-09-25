package graph;
import java.util.*;
public class _994_rotting_oranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        Set<List<Integer>> seen = new HashSet<>();
        int totalOrange = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                    seen.add(Arrays.asList(i, j));
                }
                if(grid[i][j] == 1 || grid[i][j] == 2) totalOrange++;
            }
        }
        int freshOrange = totalOrange - seen.size();
        if( freshOrange == 0) return 0;
        int res = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int z = 0; z < size; z++) {
                int[] point = q.poll();
                for(int[] dir: dirs) {
                    int i = point[0]+dir[0];
                    int j = point[1]+dir[1];
                    if(i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1 && !seen.contains(Arrays.asList(i, j))){
                        q.add(new int[]{i, j});
                        seen.add(Arrays.asList(i, j));
                    }
                }
            }
            res++;
        }
        return totalOrange == seen.size()? res-1 : -1;
    }
}
