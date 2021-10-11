package greedy;

import java.util.Arrays;
/*
 Tried many ways: only this works
 [a, b, c, d, e, f, g] (sorted)
      <-i mid      <-j
 this works for edge case like [4,5,5,6]
 */
public class _324_wiggle_sort_ii_sort {
    public void wiggleSort(int[] nums) {
        if(nums.length < 2) return;
        Arrays.sort(nums);
        int n = nums.length;
        int[] temp = new int[n];
        int mid = (n-1)/2;
        int i = mid, j = n-1;

        for(int k = 0; k < n; k++) {
            if(k % 2 == 0) {
                temp[k] = nums[i--];
            } else {
                temp[k] = nums[j--];
            }
        }

        System.arraycopy(temp, 0, nums, 0, n);
    }
}
