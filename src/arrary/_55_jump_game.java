package arrary;

public class _55_jump_game {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int end = 0;

        for(int i= 0; i <= end; i++)    {
            end = Math.max(end, i + nums[i]);
            if(end >= n-1)
                return true;
        }
        return false;
    }
}
