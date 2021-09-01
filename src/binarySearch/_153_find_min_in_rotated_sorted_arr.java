package binarySearch;

public class _153_find_min_in_rotated_sorted_arr {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        if(nums[left] < nums[right]) return nums[left];

        // searching for decreasing point
        while(left < right) {
            int mid = (left + right)/2;
            if(nums[mid] > nums[mid+1]) return nums[mid+1];

            // nums[mid] < nums[mid+1]
            if(nums[left] < nums[mid]) left = mid+1;
            else right = mid;
        }
        return nums[0]; // when nums.length == 1
    }
}
