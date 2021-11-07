package arrary;

import java.util.Random;

public class _quick_sort {
    void quicksort(int[] A, int start, int end) {
        if (start < end) {
            int index = partition(A, start, end);
            quicksort(A, start, index - 1);
            quicksort(A, index + 1, end);
        }
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
