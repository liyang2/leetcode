package dp;
import java.util.*;
public class _764_largest_plus_sign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        Set<Integer> mineSet = new HashSet<>();
        int res = 0;
        for(int[] mine: mines) {
            mineSet.add(mine[0] * n + mine[1]);
        }

        // imagine there are 4 sets of int[][] dp, for 4 directions
        // dp[left][i][j] means the longest arms length for (i,j) on the left
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            // right -> left
            int count = 0;
            for(int j = 0; j < n; j++) {
                count = mineSet.contains(i * n + j) ? 0 : count+1;
                dp[i][j] = count;
            }

            // left -> right
            count = 0;
            for(int j = n-1; j >= 0; j--) {
                count = mineSet.contains(i * n + j) ? 0 : count+1;
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }

        for(int j = 0; j < n; j++) {
            // bot -> top
            int count = 0;
            for(int i = 0; i < n; i++) {
                count = mineSet.contains(i * n + j) ? 0 : count+1;
                dp[i][j] = Math.min(dp[i][j], count);
            }

            // top -> bot
            count = 0;
            for(int i = n-1; i >= 0; i--) {
                count = mineSet.contains(i * n + j) ? 0 : count+1;
                dp[i][j] = Math.min(dp[i][j], count);
                res= Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
