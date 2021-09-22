package amazon;

import pojos.ListNode;

// space requirement: O(1)
public class _linkedlist_max_sum_head_tail {
    int maxSum(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverse(head2);
        int res = 0;
        while(node != null) {
            int val = node.val;
            int val2 = head2 == null ? val : head2.val;
            res = Math.max(res, val + val2);
            node = node.next;
            head2 = head2 == null? null : head2.next;
        }
        return res;
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode first = head;
        ListNode second = head.next;
        while(second != null) {
            ListNode third = second.next;
            second.next = first;
            first.next = prev;
            prev = first;
            first = second;
            second = third;
        }
        return first;
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
    }

    static void testCase1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        _linkedlist_max_sum_head_tail solution = new _linkedlist_max_sum_head_tail();
        System.out.println(solution.maxSum(n1));
    }

    static void testCase2() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        _linkedlist_max_sum_head_tail solution = new _linkedlist_max_sum_head_tail();
        System.out.println(solution.maxSum(n1));
    }

}
