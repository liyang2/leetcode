package slidingWindow;

public class _487_max_consecutive_ones_ii {
    public int findMaxConsecutiveOnes(int[] nums) {
        int k = 1;
        int res = 0;
        int l = 0, r = 0;
        int n = nums.length;

        for(; r < n; r++) {
            if(nums[r]== 0) {
                k--;
            }
            while(k < 0) {
                if(nums[l++] == 0) {
                    k++;
                }
            }
            res = Math.max(res, r - l +1);
        }
        return res;
    }
}
