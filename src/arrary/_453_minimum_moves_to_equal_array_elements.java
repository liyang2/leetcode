package arrary;

import java.util.Arrays;

public class _453_minimum_moves_to_equal_array_elements {
    // this is not an easy question lol
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = nums.length-1; i> 0; i--) {
            res += nums[i] - nums[0];
        }
        return res;
    }
}