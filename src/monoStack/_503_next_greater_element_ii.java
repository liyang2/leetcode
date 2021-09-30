package monoStack;

import java.util.*;

public class _503_next_greater_element_ii {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n * 2; i++) {
            int idx = i % n;
            while(!stack.isEmpty() && nums[idx] > nums[stack.peek()]) {
                res[stack.pop()] = nums[idx];
            }
            stack.push(idx);
        }
        return res;
    }

    public static void main(String[] args) {
        new _503_next_greater_element_ii().nextGreaterElements(
                new int[]{1,2,1}
        );
    }
}
