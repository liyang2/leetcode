package arrary;

public class _238_product_array_except_self {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; i++) {
            res[i] = res[i-1] * nums[i-1];
        }

        int d = 1;
        for(int i = n-2; i >= 0; i--){
            d = d * nums[i+1];
            res[i] *= d;
        }
        return res;
    }
}
