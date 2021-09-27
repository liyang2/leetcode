package graph;

import java.util.*;

public class _909_snakes_and_ladders_v2 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n*n+1];
        Queue<Integer> q = new LinkedList<>(); // stores the number of each square
        int steps = 0;
        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size -- > 0) {
                int cell = q.poll();
                if(cell == n*n) return steps;

                for(int c = cell+1; c <= Math.min(n*n, cell+6) ;c++) {
                    int next = getNext(board, c);
                    if(!visited[next]) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private int getNext(int[][]board, int target) {
        int n = board.length;
        int row = (target - 1) / n, col = (target - 1) % n;
        int x = n - 1 - row, y = row % 2 == 0 ? col : n - 1 - col;
        return board[x][y] == -1 ? target : board[x][y];
    }
}
