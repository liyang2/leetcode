package binarySearch;

public class _162_find_peak_element {
    public int findPeakElement(int[] nums) {
        int i = 0;
        int j = nums.length -1;
        while(i < j) {
            int mid = (i+j)/2;
            if(nums[mid] > nums[mid+1]) {
                j = mid;
            } else {
                i = mid + 1;
            }

            // nums[i] != nums[i + 1] for all valid i.
        }
        return j;
    }
}
