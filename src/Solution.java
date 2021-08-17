import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

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
        int pivot = nums[l];
        while(l < r) {
            while(l < r && nums[l] < pivot) l++;
            while(l < r && nums[r] > pivot) r--;
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
        return l;
    }

    public static void main(String[] args) {
        new Solution().sortArray(new int[]{5,1,1,2,0,0});
    }
}