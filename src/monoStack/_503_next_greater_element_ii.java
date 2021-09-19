package monoStack;
import java.util.*;
public class _503_next_greater_element_ii {

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < 2*nums.length; i++) {
            int idx = i % nums.length;
            while(!stack.isEmpty() && nums[stack.peek()] < nums[idx]) {
                res[stack.pop()] = nums[idx];
            }
            stack.push(idx);
        }
        return res;
    }
}
