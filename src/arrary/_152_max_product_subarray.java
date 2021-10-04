package arrary;

public class _152_max_product_subarray {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int res = nums[0];

        for(int i= 1; i < nums.length; i++) {

            // newMax/newMin will be updated in 3 possible ways, and nums[i] will impact all of them
            int newMax =  Math.max(nums[i], Math.max(min * nums[i], max * nums[i]));
            int newMin =  Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));
            res = Math.max(res, newMax);
            min = newMin;
            max = newMax;
        }
        return res;
    }
}
