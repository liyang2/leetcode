package arrary;

public class _287_find_duplicate_number {
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while(fast != slow);
        // now fast and slow met

        int head = nums[0];
        while(head != slow) {
            head = nums[head];
            slow = nums[slow];
        }
        return slow;
    }
}
