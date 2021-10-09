package grid;

import java.util.ArrayList;
import java.util.List;

public class _130_surrounded_regions {
    char[][] board;
    int m, n;

    public void solve(char[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;

        List<int[]> borders = new ArrayList<>();
        for(int i = 0; i < m; i++){
            borders.add(new int[]{i, 0});
            borders.add(new int[]{i, n-1});
        }
        for(int j = 0; j < n; j++) {
            borders.add(new int[]{0, j});
            borders.add(new int[]{m-1, j});
        }
        for(int[] cell : borders) {
            dfs(cell[0], cell[1]); // marks 'O' to 'E'
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'E') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    final int[][] dirs= {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    void dfs(int i, int j) {
        if(i < 0 || i == m || j < 0 || j ==n || board[i][j] != 'O')
            return;
        board[i][j] = 'E';
        for(int[] dir: dirs) {
            dfs(i+dir[0], j+dir[1]);
        }
    }
}
