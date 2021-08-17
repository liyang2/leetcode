package graph;

import java.util.*;

public class _1197_minimum_knight_moves {
    public int minKnightMoves(int x, int y) {
        if(x == 0 && y == 0) return 0;
        int[][] dirs = {
                {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2},{2,-1}
        };
        int res = 0;
        boolean[][] visited = new boolean[605][605];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[302][302] = true;

        while(!q.isEmpty()) {
            int size = q.size();
            res ++;

            for(int i = 0; i < size; i++) {
                int[] point = q.poll();

                for(int[] dir: dirs) {
                    int newX = point[0] + dir[0];
                    int newY = point[1] + dir[1];
                    if(newX == x && newY == y) return res;

                    if(!visited[302 + newX][302 + newY]) {
                        q.add(new int[]{newX, newY});
                        visited[302 + newX][302+newY] = true;
                    }
                }
            }
        }
        return res;
    }

}
