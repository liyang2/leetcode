package dataStructure;

import java.util.Stack;

public class _155_Min_stack {
}
class MinStack {

    Stack<Item> stack = new Stack<>();
    public MinStack() {

    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Item(val, val));
        } else {
            stack.push(new Item(val, Math.min(val, stack.peek().min)));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}

class Item {
    int val;
    int min;
    public Item(int val, int min) {
        this.val = val;
        this.min = min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */