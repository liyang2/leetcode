package arrary;

public class _88_merge_sorted_array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m-1; i >= 0; i--) {
            nums1[i+n] = nums1[i];
        }

        int i = n, j = 0, k = 0;
        while(i < m + n && j < n) {
            if(nums1[i] < nums2[j]) {
                nums1[k++] = nums1[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }
        while(i < m + n -1) {
            nums1[k++] = nums1[i++];
        }
        while(j < n) {
            nums1[k++] = nums2[j++];
        }
    }
}
