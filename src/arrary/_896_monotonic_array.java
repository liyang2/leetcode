package arrary;

public class _896_monotonic_array {
    public boolean isMonotonic(int[] nums) {
        boolean foundUp = false;
        boolean foundDown = false;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                foundUp = true;
            }
            if(nums[i] < nums[i-1]) {
                foundDown = true;
            }
        }
        if(foundUp && foundDown) return false;

        return true;
    }
}
