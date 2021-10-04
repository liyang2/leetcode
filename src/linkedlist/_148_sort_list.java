package linkedlist;

import pojos.ListNode;
import utility.ListBuilder;

public class _148_sort_list {
    public static void main(String[] args) {
        ListNode head = new ListBuilder().buildList(new int[]{4,2,1,3});
        ListNode sorted = new _148_sort_list().sortList(head);
        System.out.println();
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(left != null || right != null) {
            if(left == null) {
                cur.next = right;
                break;
            }
            else if(right == null) {
                cur.next = left;
                break;
            }
            else {
                if(left.val < right.val) {
                    cur.next = left;
                    left = left.next;
                } else {
                    cur.next = right;
                    right = right.next;
                }
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    // return begining of right half
    ListNode getMid(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev == null)
            return null;
        prev.next = null;
        return slow; // slow is prev.next
    }
}
