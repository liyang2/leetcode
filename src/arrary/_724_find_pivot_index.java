package arrary;

public class _724_find_pivot_index {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;
        int curSum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(curSum == sum - nums[i] - curSum) return i;
            curSum += nums[i];
        }
        return -1;
    }
}
