package monoStack;

import java.util.Stack;

public class _84_largest_rectangle_histogram {
    // mono stack means strictly increasing
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // suppose there's only 1 ele with index 0, with = 0 - (-1) = 1
        int res = 0;

        for(int i = 0; i < heights.length; i++) {
            int h = heights[i];
            while(stack.peek() != -1 && h <= heights[stack.peek()]) {
                int curH = heights[stack.pop()];
                int curW = i-1 - stack.peek();
                // you can assume all the bars (stack.peek(), i-1] are higher or equal to curH
                res = Math.max(res, curH * curW);
            }
            stack.push(i);
        }
        // now you can assume all the bars (stack.peek(), heights.length-1] are higher or equal to heights[curIdx]
        while(stack.peek() != -1 ) {
            int curH = heights[stack.pop()];
            int curW = heights.length-1 - stack.peek();
            res = Math.max(res, curH * curW);
        }
        return res;
    }
}
