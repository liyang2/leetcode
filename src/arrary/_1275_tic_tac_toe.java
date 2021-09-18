package arrary;

public class _1275_tic_tac_toe {
    public String tictactoe(int[][] moves) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diagonal = 0;
        int antiDiagonal = 0;
        int player = 1; // and -1

        for(int[] move : moves) {
            int r = move[0];
            int c = move[1];
            rows[r] += player;
            cols[c] += player;
            if(r == c)
                diagonal += player;
            if(r + c == 2)
                antiDiagonal += player;
            if(Math.abs(rows[r]) == 3 || Math.abs(cols[c]) == 3 ||
                    Math.abs(diagonal) == 3 || Math.abs(antiDiagonal) == 3) {
                return player == 1 ? "A" : "B";
            }
            player *= -1;
        }
        if(moves.length == 9)
            return "Draw";
        else
            return "Pending";
    }
}
