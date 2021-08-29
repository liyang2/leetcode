package math;

public class _330_patching_array {
    // start with [1, miss), miss is smallest uncovered element
    // if we found a number in nums x <= miss, our covered range extends to [1, x+miss)

    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int res = 0;
        int i = 0;

        while(miss <= n) {
            if(i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                res++;
            }
        }
        return res;
    }
}
