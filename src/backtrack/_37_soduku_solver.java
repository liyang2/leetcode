package backtrack;

import java.util.*;

public class _37_soduku_solver {
    public void solveSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    set.add(getKey("row", i, board[i][j]));
                    set.add(getKey("col", j, board[i][j]));
                    set.add(getKey("box", i/3*3+j/3, board[i][j]));
                }
            }
        }
        solveSudokuHelper(board, set);
    }

    boolean solveSudokuHelper(char[][] board, Set<String> set) {
        for(int i  = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') continue;
                for(char ch = '1'; ch <= '9'; ch++) {
                    if(isValid(board, i, j, ch, set)) {
                        board[i][j] = ch;
                        set.add(getKey("row", i, ch));
                        set.add(getKey("col", j, ch));
                        set.add(getKey("box", i/3*3+j/3, ch));

                        if(solveSudokuHelper(board, set)) {
                            return true;
                        }
                        board[i][j] = '.';
                        set.remove(getKey("row", i, ch));
                        set.remove(getKey("col", j, ch));
                        set.remove(getKey("box", i/3*3+j/3, ch));
                    }

                }
                return false;
            }
        }
        return true;
    }
    boolean isValid(char[][] board, int i , int j, char ch, Set<String> set) {
        return !set.contains(getKey("row", i, ch)) &&
                !set.contains(getKey("col", j, ch)) &&
                !set.contains(getKey("box", i/3*3+j/3, ch));
    }

    String getKey(String iden, int i, char ch) {
        return iden + i + " " + ch;
    }
}
