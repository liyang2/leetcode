package stack;

import java.util.Stack;

public class _1614_max_nesting_depth_of_parentheses {
    public int maxDepth(String s) {
        int res = 0;
        Stack<Character> stack = new Stack<>();

        int i = 0;
        while(i < s.length()) {
            while(i < s.length() && s.charAt(i) != '(' && s.charAt(i) != ')') {
                i++;
            }
            if(i == s.length()) break;
            if(s.charAt(i) == '(') {
                stack.push('(');
            } else if(s.charAt(i) == ')') {
                stack.pop();
            }
            res = Math.max(res, stack.size());
            i++;
        }
        return res;
    }
}
