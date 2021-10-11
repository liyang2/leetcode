package arrary;

import java.util.Random;

public class _215_kth_largest_element_in_an_array {
    public static void main(String[] args) {
        System.out.println(new _215_kth_largest_element_in_an_array().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

    public int findKthLargest(int[] nums, int k) { // k is 1 based
        int n = nums.length;
        return helper(nums, 0, n-1, n-k);
    }

    // find element at index k (0 based)
    int helper(int[] nums, int left, int right, int k) {
        if(left == right)
            return nums[left];

        int index = partition(nums, left, right);
        if(k == index) {
            return nums[k];
        } else if(k > index) {
            return helper(nums, index+1, right, k);
        } else {
            return helper(nums, left, index-1, k);
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
