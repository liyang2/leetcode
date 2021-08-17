package amazon;

import java.util.*;

// https://algo.monster/problems/two_sum_unique_pairs
public class _two_sum_unique_pairs {
    public static int twoSumUniquePairs(List<Integer> numList, int target) {
        // WRITE YOUR BRILLIANT CODE HERE
        Integer[] nums = new Integer[numList.size()];
        numList.toArray(nums);
        Arrays.sort(nums);
        int left = 0, right = nums.length-1;

        int res = 0;
        while(left < right) {
            while(left > 0 && nums[left-1] == nums[left]) left++;
            while(right < nums.length-1 && nums[right+1] == nums[right]) right--;
            if(left >= right) break;

            int sum = nums[left] + nums[right];
            if(sum == target) {
                res++;
                left++;
                right--;
            } else if(sum < target) {
                left++;
            } else {
                right--;
            }

        }
        return res;
    }
}
