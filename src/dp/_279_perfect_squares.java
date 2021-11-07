package dp;
import java.util.*;

// this one is exactly like coin change
public class _279_perfect_squares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;


        // dp[i] stores least number of perfect square numbers that sum to i
        for (int i = 1; i * i <= n; i++) {
            int item = i * i;
            for (int volumn = 1; volumn <= n ; volumn++) {
                if (volumn >= item)
                    dp[volumn] = Math.min(dp[volumn], dp[volumn - item] + 1);
            }
        }
        return dp[n];
    }
}
