package backtrack;

public class _1863_sum_of_all_subset_xor_totals {
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }

    int helper(int[] nums, int i, int cur) {
        if(i == nums.length)
            return cur;
        return helper(nums, i+1, cur ^ nums[i]) +
                helper(nums, i+1, cur);
    }
}
