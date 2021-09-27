package graph;
import java.util.*;

// convert to 1D array first
public class _909_snakes_and_ladders_v1 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n*n+1];
        boolean[] visited = new boolean[n*n+1];
        int i = n-1, j = 0;
        int dir = 1;
        int idx = 1;
        while(idx <= n * n) {
            arr[idx++] = board[i][j];
            if(dir == 1 && j == n-1) {
                i--;
                dir = -1;
            } else if(dir == -1 && j == 0) {
                i--;
                dir = 1;
            } else {
                j += dir;
            }
        }
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
                    int next = arr[c] == -1 ? c : arr[c];
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
}
