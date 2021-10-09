package stack;

import java.util.Stack;

public class _227_basic_calculator_ii {

    public static void main(String[] args) {
        new _227_basic_calculator_ii().calculate("3+2*2");
    }

    public int calculate(String s) {
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        char last = '+';
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(Character.isDigit(cur)) {
                num = num * 10 + cur - '0';
            }

            if(i == s.length() - 1 || isOperator(cur) ) {
                if(last == '+') {
                    stack.push(num);
                } else if(last == '-') {
                    stack.push(-num);
                } else if(last == '*') {
                    stack.push(stack.pop() * num);
                } else if(last == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                last = cur;
            }
        }
        int res = 0;
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
}
