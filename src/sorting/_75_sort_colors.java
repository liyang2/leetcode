package sorting;

public class _75_sort_colors {
    public void sortColors(int[] nums) {
        int start = 0;
        for (int color = 0; color < 3; color++) {
            for (int i = start; i < nums.length; i++) {
                if (nums[i] == color) {
                    swap(nums, i, start++);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
