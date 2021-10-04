package utility;

import pojos.ListNode;

public class ListBuilder {

    public ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for(int n : arr) {
            cur.next = new ListNode(n);
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node  = new ListBuilder().buildList(new int[]{4,2,1,3});
        System.out.println();
    }
}
