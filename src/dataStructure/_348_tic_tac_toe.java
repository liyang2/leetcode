package dataStructure;

public class _348_tic_tac_toe {
    int[] rows;
    int[] cols;
    int diagonal = 0;
    int anti = 0;
    int n;

    public _348_tic_tac_toe(int n) {
        rows = new int[n];
        cols = new int[n];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        if(player == 2)
            player = -1;
        rows[row] += player;
        cols[col] += player;
        if(row == col)
            diagonal += player;
        if(row + col == n-1)
            anti += player;
        if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n
                || Math.abs(diagonal) == n || Math.abs(anti) == n)
            return player == 1 ? 1 : 2;
        return 0;
    }
}
