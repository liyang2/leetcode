package dp;

import java.util.*;

public class _322_coin_change {
    // i.e. amount == 11, coins = {1,2,5}
    // dp[11] = min(dp[11-1]+1, dp[11-2]+1, dp[11-5]+1)

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= amount; i++) {
            for(int c : coins) {
                if(c <= i && dp[i - c] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - c]+1);
                }
            }
        }
        if(dp[amount] == Integer.MAX_VALUE) return -1;
        else return dp[amount];
    }
}
