package slidingWindow;

// another "at least" problem
public class _209_minimum_size_subarray_sum {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int sum = 0;
        int res = nums.length+1;

        for(r = 0; r < nums.length; r++) {
            sum += nums[r];
            while(l <=r && sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
        }
        if(res == nums.length+1)
            return 0;
        return res;
    }
}
