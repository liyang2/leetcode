package binarySearch;

public class _153_find_min_in_rotated_sorted_arr {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else // if(nums[mid] > nums[right]) {
                left = mid + 1;
        }
        return Math.min(nums[left], nums[right]);
    }
}
