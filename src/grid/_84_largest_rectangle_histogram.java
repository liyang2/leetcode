package grid;

import java.util.Stack;

public class _84_largest_rectangle_histogram {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i <= heights.length; i++) {
            int heightAtI = i == heights.length ? -1 : heights[i];
            while(!stk.isEmpty() && heightAtI < heights[stk.peek()]) {
                int height = heights[stk.pop()];
                int left = stk.isEmpty() ? -1 : stk.peek(); // if stk.isEmpty(), it means bars on the left all taller and has been popped
                int right = i;
                res = Math.max(res, (right - left - 1) * height);
            }
            stk.push(i);
        }
        return res;
    }
}
