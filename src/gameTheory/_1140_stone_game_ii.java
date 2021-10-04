package gameTheory;
//https://leetcode.com/problems/stone-game-ii/discuss/345354/Java-DP-with-memorization-easy-to-understand(with-explanation)

public class _1140_stone_game_ii {
    int[][] dp;
    int[] postSum;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];
        postSum = new int[n];
        postSum[n-1] = piles[n-1];
        for(int i = n-2; i >= 0; i--){
            postSum[i] = piles[i] + postSum[i+1];
        }
        return helper(piles, 0, 1);
    }

    int helper(int[] piles, int start, int M) {
        if(start >= piles.length) return 0;
        if(start + 2*M >= piles.length) return postSum[start];
        // M <= piles.length/2
        if(dp[start][M] > 0) return dp[start][M];

        // min of stones for other player
        int other = Integer.MAX_VALUE;
        for(int x = 1; x <= 2*M; x++) {
            other = Math.min(other, helper(piles, start + x, Math.max(M, x)));
        }
        int res = postSum[start] - other;
        dp[start][M] = res;
        return res;
    }
}
