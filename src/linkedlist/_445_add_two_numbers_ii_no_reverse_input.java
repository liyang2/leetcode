package linkedlist;

import pojos.ListNode;

public class _445_add_two_numbers_ii_no_reverse_input {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLen(l1);
        int len2 = getLen(l2);

        ListNode prev= null;
        while(len1 > 0 && len2 > 0) {
            ListNode node = null;
            if(len1 > len2) {
                node = new ListNode(l1.val);
                l1 = l1.next;
                len1--;
            } else if(len1 == len2) {
                node = new ListNode(l1.val + l2.val);
                l1 = l1.next;
                l2 = l2.next;
                len1--;
                len2--;
            } else {
                node = new ListNode(l2.val);
                l2 = l2.next;
                len2--;
            }
            node.next = prev;
            prev = node;
        }

        //reverse output
        int inc = 0;
        ListNode node = prev;
        prev = null;
        while(node != null) {
            ListNode next= node.next;
            node.next = prev;

            node.val += inc;
            inc = node.val / 10;
            node.val %= 10;

            prev = node;
            node = next;
        }
        if(inc > 0) {
            ListNode head = new ListNode(inc);
            head.next = prev;
            prev= head;
        }
        return prev;
    }

    int getLen(ListNode node) {
        int res = 0;
        while(node != null) {
            res++;
            node = node.next;
        }
        return res;
    }
}
