package dp;

import java.util.Arrays;

public class _123_stock_iii {
    public int maxProfit(int[] prices) {
         /*
         * 定义 5 种状态:
         * 0: 直到现在一直没有操作,
           1: 直到现在只发生了第一次买入,
           2: 直到现在只发生了第一次卖出,
           3: 直到现在只发生了第二次买入,
           4: 直到现在只发生了第二次卖出
         */
        int n = prices.length;
        int[][] dp = new int[n][5];
        for(int[] arr : dp) Arrays.fill(arr, -10000);

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0];
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3] + prices[i]);
        }

        int res = 0;
        for(int j = 0; j <= 4; j++) {
            res = Math.max(res, dp[n-1][j]);
        }
        return res;

    }

    public static void main(String[] args) {
        new _123_stock_iii().maxProfit(new int[] {7, 6, 4, 3, 1});
    }
}
