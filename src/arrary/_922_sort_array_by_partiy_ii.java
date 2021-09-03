package arrary;

public class _922_sort_array_by_partiy_ii {
    int j = 1; // i is even, j is odd
    public int[] sortArrayByParityII(int[] nums) {
        for(int i = 0; i < nums.length;i += 2) {
            if(nums[i] % 2 == 1) {
                // find the next bad j
                while(nums[j] % 2 == 1) {
                    j+= 2;
                }
                swap(nums, i, j);
            }

        }
        return nums;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
