package grid;

public class _289_game_of_life {
    // 1->0: -1
    // 0->1:  2
    int m, n;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;

        for(int i = 0;i < m; i++) {
            for(int j = 0; j < n; j++) {
                int live = liveNeighbors(board, i, j);
                if(board[i][j] == 1) {
                    if(live < 2 || live > 3)
                        board[i][j] = -1;
                } else { // 0
                    if(live == 3)
                        board[i][j] = 2;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == -1)
                    board[i][j] = 0;
                else if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }

    int[] d = {0, 1, -1};
    int liveNeighbors(int[][] board, int row, int col) {
        int res = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(!(i == 0 && j == 0)) {
                    int r = row + d[i];
                    int c = col + d[j];

                    // we want board[i][j] in {1, -1}
                    if(r >= 0 && r < m && c >= 0 && c < n && Math.abs(board[r][c]) == 1)
                        res ++;
                }
            }
        }
        return res;
    }
}
