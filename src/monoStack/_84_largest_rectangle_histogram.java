package monoStack;

import java.util.Stack;

public class _84_largest_rectangle_histogram {
    public int largestRectangleArea(int[] heights) {
        // write your code here
        int res = 0;
        Stack<Item> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int curHeight = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && stack.peek().height > curHeight) {
                Item popped = stack.pop(); // 每次pop找到左边界和右边界
                int width = 0;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - 1 - stack.peek().index;
                }

                res = Math.max(res, width * popped.height);
            }
            stack.add(new Item(curHeight, i));
        }
        return res;
    }
}

class Item {
    int height;
    int index;
    public Item(int height, int index) {
        this.height = height;
        this.index = index;
    }
}
