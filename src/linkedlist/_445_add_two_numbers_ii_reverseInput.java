package linkedlist;

import pojos.ListNode;

public class _445_add_two_numbers_ii_reverseInput {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int inc = 0;
        ListNode prev= null;
        while(l1 != null || l2 != null || inc > 0) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int n = n1 + n2 + inc;
            inc = n / 10;
            n %=10;
            ListNode node = new ListNode(n);
            node.next = prev;
            prev = node;

            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;
        }
        return prev;
    }

    ListNode reverse(ListNode node) {
        ListNode prev = null;
        while(node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
