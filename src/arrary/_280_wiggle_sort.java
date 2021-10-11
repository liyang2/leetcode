package arrary;

public class _280_wiggle_sort {
    public void wiggleSort(int[] nums) {
        boolean less = true;
        for(int i = 0; i < nums.length-1; i++) {
            if(less) {
                if(nums[i] > nums[i+1]) {
                    swap(nums, i, i+1);
                }
            } else {
                if(nums[i] < nums[i+1]) {
                    swap(nums, i, i+1);
                }
            }
            less= !less;
        }
    }
    void swap(int[] nums, int i , int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
