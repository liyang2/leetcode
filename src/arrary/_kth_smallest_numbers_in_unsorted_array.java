package arrary;

import java.util.Random;

public class _kth_smallest_numbers_in_unsorted_array {
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        k--; // 0 indexed
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int index = partition(nums, left, right);
            if (index == k) {
                return nums[index];
            } else if (index < k) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return -1;
    }

    int partition(int[] nums, int left, int right) {
        if (left == right) return left;
        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left);
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int leftEnd = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot)
                swap(nums, i, leftEnd++);
        }
        swap(nums, leftEnd, right);
        return leftEnd;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
