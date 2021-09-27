package slidingWindow;

public class _1248_count_number_of_nice_subarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k-1);
    }

    int atMostK(int[] nums, int k) {
        int l = 0, r = 0;
        int res = 0;
        int odd = 0;
        for(r= 0; r < nums.length; r++) {
            if(nums[r] % 2 == 1) {
                odd++;
            }
            while(l <= r && odd > k) {
                if(nums[l++] % 2 == 1) {
                    odd--;
                }
            }
            res += r -l + 1;
        }
        return res;
    }
}
