package dp;

public class _416_partition_equal_subset_sum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;
        if(sum % 2 == 1) return false;
        sum /= 2;

        // knapsack problem
        boolean[][] dp = new boolean[nums.length+1][sum + 1];
        dp[0][0] = true;
        // first column: sum == 0
        for(int i = 1; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        // first row: empty set, values are already false

        // because i=0 means empty set, i maps to i-1 th element in nums
        for(int i = 1; i <= nums.length; i++) {
            for(int j = 1; j <= sum; j++) {
                if(dp[i-1][j] || (j-nums[i-1] >= 0 && dp[i-1][j-nums[i-1]]))
                    dp[i][j] = true;
            }
        }
        return dp[nums.length][sum];
    }
}
