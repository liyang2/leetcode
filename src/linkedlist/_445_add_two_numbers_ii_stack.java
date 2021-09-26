package linkedlist;

import pojos.ListNode;

import java.util.*;
public class _445_add_two_numbers_ii_stack {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = buildStack(l1);
        Stack<Integer> stack2 = buildStack(l2);
        int inc = 0;
        ListNode prev = null;
        while(!stack1.isEmpty() || !stack2.isEmpty() || inc > 0) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = num1 + num2 + inc;
            inc = sum/10;
            sum %=10;

            ListNode node = new ListNode(sum);
            node.next = prev;
            prev = node;
        }
        return prev;
    }

    Stack<Integer> buildStack(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        while(node != null) {
            stack.push(node.val);
            node = node.next;
        }
        return stack;
    }
}
