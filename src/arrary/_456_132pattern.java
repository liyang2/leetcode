package arrary;

public class _456_132pattern {

    // time limit exceeded for the last test case on leetcode
    // however the improved code is impossible to come up during interview
    // this is the best I can do, fuck it
    public boolean find132pattern(int[] nums) {
        int min = nums[0];
        for(int j = 1; j < nums.length; j++) {
            min = Math.min(min, nums[j]);

            for(int k = j+1; k < nums.length; k++) {
                if(nums[k] > min && nums[k] < nums[j]) return true;
            }
        }
        return false;
    }
}
