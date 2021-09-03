package arrary;

public class _189_rotate_array {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] temp = new int[k];
        for(int i = nums.length-1; i >= nums.length-k; i--) {
            temp[k-(nums.length-i)] = nums[i];
        }

        for(int i = nums.length-k-1; i >= 0; i--) {
            nums[i+k] = nums[i];
        }

        for(int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}
