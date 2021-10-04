package gameTheory;

public class _877_stone_game {
    // https://leetcode.com/problems/stone-game/discuss/154610/DP-or-Just-return-true
    public boolean stoneGame(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][n];
        // dp[i][j] means (max stones Alice can have) - (max stones Bob can have)
        // dp[i][j] = max(p[i] - dp[i+1][j], p[j] - dp[i][j-1])

        // 对角线
        for(int i = 0; i < n; i++) {
            dp[i][i] = p[i];
        }

        // 对角线上方
        for(int d = 1; d < n; d++) {
            for(int i = 0; i+d < n; i++) {
                int j = i + d;
                dp[i][j] = Math.max(p[i] - dp[i+1][j], p[j]-dp[i][j-1]);
            }
        }
        return dp[0][n-1] > 0;
    }
}
