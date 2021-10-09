package binaryIndexedTree;

import java.util.*;

public class _315_count_of_smaller_numbers_after_self_BIT {
    final int offset = 10000;
    // the original imaginary array storing counts of each value is of size: 2 * offset + 1
    // bit array is always 1 more, bit[0] is not used
    final int size =  2 * offset + 2;
    final int[] bit = new int[size];

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int i = nums.length-1; i >= 0; i--) {
            int smaller_count = query(nums[i]+offset-1); // -1 because of 'smaller'
            res.add(smaller_count);
            update(nums[i]+offset, 1);
        }
        Collections.reverse(res);
        return res;
    }

    // index is 0 based
    void update(int index, int val) {
        index++;
        while(index < size) {
            bit[index] += val;
            index += index & -index;
        }
    }

    // index is 0 based
    int query(int index) {
        index++;
        int res = 0;
        while(index > 0) {
            res += bit[index];
            index -= index & -index;
        }
        return res;
    }
}
