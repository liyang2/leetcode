package binaryIndexedTree;

public class _307_range_sum_query_mutable {
}

class NumArray {

    int[] sums;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        sums = new int[n+1];
        for(int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    private int lowestBit(int i) {
        return i & -i;
    }

    // index is 0-based
    public void update(int index, int val) {
        int orig = prefixSum(index) - prefixSum(index-1);
        index++; //1 based
        int delta = val - orig;
        while(index <= n) {
            sums[index] += delta;
            index += lowestBit(index);
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum(right) - prefixSum(left-1);
    }

    // index is 0 based
    private int prefixSum(int index) {
        index++;
        int sum = 0;
        while(index > 0) {
            sum += sums[index];
            index -= lowestBit(index);
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
