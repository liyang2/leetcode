package slidingWindow;

public class _930_binary_subarrays_with_sum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMostK(nums, goal) - atMostK(nums, goal-1);
    }

    int atMostK(int[] nums, int k) {
        int l = 0, r = 0;
        int res = 0;
        int n = nums.length;
        int sum = 0;
        for(r = 0; r < n; r++) {
            sum += nums[r];
            while(l <= r && sum > k) {
                sum -= nums[l++];
            }
            res += (r - l + 1);
        }
        return res;
    }
}
