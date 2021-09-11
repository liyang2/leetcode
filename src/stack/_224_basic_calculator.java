package stack;
import java.util.*;
public class _224_basic_calculator {
    public int calculate(String s) {
        int result = 0;
        int sign = 1;
        int operand = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                operand = operand * 10 + ch - '0';
            } else if(ch == '+') {
                result += sign * operand;
                sign = 1;
                operand = 0;
            } else if(ch == '-') {
                result += sign * operand;
                sign = -1;
                operand = 0;
            } else if(ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = operand = 0;
                sign = 1;
            } else if(ch == ')') {
                result += sign * operand;
                sign = stack.pop();
                result *= sign;
                result += stack.pop();
                operand = 0;
                sign = 1;
            }
        }
        return result + sign * operand;
    }
}
