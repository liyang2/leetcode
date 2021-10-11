package greedy;

import java.util.Random;

// This solution uses O(n) time and O(n) space
// there is another O(n) time and constant space solution but too complicated
public class _324_wiggle_sort_ii_quick_select {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int mid = (n-1)/2;
        int medium = findKthSmallest(nums, 0, n-1, mid); // O(n) operation

        //setting up temp[], so that duplicate "medium" values are gathered in the middle
        int[] temp = new int[n];
        int s = 0, e = n-1;
        for(int d: nums) {
            if (d < medium)
                temp[s++] = d;
            else if (d > medium)
                temp[e--] = d;
        }
        while (s < mid)
            temp[s++] = medium;
        while (e >= mid)
            temp[e--] = medium;
        // end of setting up temp[]

        int i = mid, j = n-1;
        for(int k = 0; k < n; k++) {
            if(k % 2 == 0) {
                nums[k] = temp[i--];
            } else {
                nums[k] = temp[j--];
            }
        }

    }

    // find element at index k (0 based)
    int findKthSmallest(int[] nums, int left, int right, int k) {
        if(left == right)
            return nums[left];

        int index = partition(nums, left, right);
        if(k == index) {
            return nums[k];
        } else if(k > index) {
            return findKthSmallest(nums, index+1, right, k);
        } else {
            return findKthSmallest(nums, left, index-1, k);
        }
    }

    int partition(int[] nums, int left, int right) {
        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left);
        int pivot = nums[pivotIndex];
        int smallerIndex = left;
        swap(nums, right, pivotIndex);
        for(int i = left; i < right; i++) {
            if(nums[i] < pivot) {
                swap(nums, i, smallerIndex++);
            }
        }
        swap(nums, smallerIndex, right);
        return smallerIndex;
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
