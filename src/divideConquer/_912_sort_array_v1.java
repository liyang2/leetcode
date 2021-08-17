package divideConquer;

public class _912_sort_array_v1 {
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length-1);
        return nums;
    }


    void quicksort(int[] nums, int l, int r) {
        if(l >= r) return;
        int m = partition(nums, l, r);
        quicksort(nums, l, m-1);
        quicksort(nums, m+1, r);
    }

    int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        // nums[0..i] represents everything smaller than pivot
        // so its initial value will be low-1
        int i = l-1;
        for(int j = l; j < r; j++) {
            if(nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, r);
        return i+1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
