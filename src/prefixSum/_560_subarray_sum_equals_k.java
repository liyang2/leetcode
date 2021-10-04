package prefixSum;

import java.util.*;

// can't apply two pointers technique because nums[i] could be negative
public class _560_subarray_sum_equals_k {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] pathSum = new int[n];
        Map<Integer, Integer> map = new HashMap<>(); // count freq of each sum
        int curSum = 0;
        int res = 0;
        for(int i = 0; i < n; i++) {
            curSum += nums[i];
            if(curSum == k) {
                res ++; // this is nums[0, i]
            }
            res += map.getOrDefault(curSum - k, 0);
            map.put(curSum, map.getOrDefault(curSum, 0)+1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _560_subarray_sum_equals_k().subarraySum(new int[]{1, 2, 3}, 3));
    }
}
