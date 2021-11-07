package binarySearch;

public class _162_find_peak_element {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if ((left == 0 || nums[left] > nums[left - 1]) &&
                (left == n - 1 || nums[left] > nums[left + 1]))
            return left;
        else
            return right;
    }

}
