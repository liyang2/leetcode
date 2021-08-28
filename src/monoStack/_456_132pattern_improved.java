package monoStack;

import java.util.Stack;

public class _456_132pattern_improved {
    public boolean find132pattern(int[] nums) {
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for(int i = 1; i < min.length; i++) {
            min[i] = Math.min(min[i-1], nums[i]);
        }
        // mono stack: smallest element on top
        // stores elements on the right side of j
        Stack<Integer> stack = new Stack<>();
        for(int j = nums.length-1; j >= 0; j--) {
            while(!stack.isEmpty() && stack.peek() < nums[j]) {
                int d = stack.pop();
                if(d > min[j]) return true;
            }
            stack.push(nums[j]);
        }
        return false;
    }
}
