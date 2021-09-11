package dp;

public class _413_arithmetic_slices {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        // dp[i] represents # of slices ending at index i
        int sum = 0;
        for(int i = 2; i < nums.length; i++) {
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                dp[i] = 1 + dp[i-1];
                sum += dp[i];
            } else {
                dp[i] = 0;
            }
        }
        return sum;
    }
}
