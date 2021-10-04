package slidingWindow;

public class _1004_max_consecutive_ones_iii {
    public int longestOnes(int[] nums, int k) {
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
