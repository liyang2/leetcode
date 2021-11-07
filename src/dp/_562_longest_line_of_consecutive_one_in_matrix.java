package dp;

public class _562_longest_line_of_consecutive_one_in_matrix {
    public static void main(String[] args) {
        int[][] arr ={{1,1,1,1},{0,1,1,0},{0,0,0,1}};
        new _562_longest_line_of_consecutive_one_in_matrix().longestLine(arr);
    }
    public int longestLine(int[][] mat) {
        int res = 0;
        int m = mat.length;
        int n = mat[0].length;
        int[][][] dp = new int[m][n][4];
        // dp[i][j][0] : left
        // dp[i][j][1] : top
        // dp[i][j][2] : topLeft
        // dp[i][j][3] : botRight
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1) {
                    dp[i][j][0] = j == 0 ? 1 : dp[i][j-1][0] + 1;
                    dp[i][j][1] = i == 0 ? 1 : dp[i-1][j][1] + 1;
                    dp[i][j][2] = (i == 0 || j == 0) ? 1 : dp[i-1][j-1][2] + 1;
                    dp[i][j][3] = (i == 0 || j == n-1) ? 1 : dp[i-1][j+1][3] + 1;

                    res = Math.max(
                            res,
                            Math.max(Math.max(dp[i][j][0], dp[i][j][1]), Math.max(dp[i][j][2], dp[i][j][3])));
                }
            }
        }

        return res;
    }
}
