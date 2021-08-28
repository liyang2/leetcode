package backtrack;

public class _79_word_search {
    boolean[][] used;
    char[][] board;
    int[][] dirs = {{0, 1}, {0, -1}, {1,0}, {-1,0}};
    int m,n;
    String word;

    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        m = board.length;
        n = board[0].length;
        used = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dfs(i, j, 0))
                    return true;
            }
        }
        return false;
    }

    // ask yourself this question:
    // at the begging of the method, is board[i][j] counted already, answer is no for this one
    boolean dfs(int i, int j, int idx) {
        if(idx == word.length()) return true;
        if(i < 0 || j < 0 || i >= m || j >= n || used[i][j] ||
                board[i][j] != word.charAt(idx)) return false;

        used[i][j] = true;

        for(int[] dir: dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if(dfs(newI, newJ, idx+1)) return true;
        }
        used[i][j] = false;
        return false;
    }
}
