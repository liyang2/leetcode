package arrary;

// I don't like
public class _41_first_missing_positive {
    public static void main(String[] args) {
        int[] arr = {3,4,-1,1};
        new _41_first_missing_positive().firstMissingPositive(arr);
    }
    public int firstMissingPositive(int[] nums) {
        //find out if 1 is missing
        boolean missing = true;
        for(int n : nums) {
            if(n== 1) missing = false;
        }
        if(missing) return 1;

        //edge case
        if(nums.length == 1 && nums[0] == 1) return 2;

        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0) {
                nums[i] = 1;
                // it has to be a non-zero number so that it has the ability to hold
                // the information of "+/-" sign, but now we can't know if 1 is missing
                // that's why we find it out beforehand
            }
        }

        // after below for loop, this array can now tell us any number within range [1, n] is missing directly,
        // and we can infer that n+1 is missing if all of [1,n] is present
        for(int i = 0; i < n; i++) {
            int idx = positive(nums[i]);
            if(idx < n)
                nums[idx] = neg(nums[idx]);
            else if(idx == n)
                nums[0] = neg(nums[0]);
                // there will be no 0 after above for loop, and cell at index 0 is wasted
                // so we can use it to indicate if we found number n
        }
        for(int i = 1; i < n; i++) {
            if(nums[i] > 0) {
                return i;
            }
        }
        if(nums[0] < 0) // meaning n is found too
            return n+1;
        return n;
    }

    int positive(int num) {
        return num < 0 ? -num : num;
    }
    int neg(int num) {
        return num < 0 ? num : -num;
    }
}
