package math;

public class _268_missing_number {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int d: nums) sum += d;
        return n*(n+1)/2 - sum;
    }
}
