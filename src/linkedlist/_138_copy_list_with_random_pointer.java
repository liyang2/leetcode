package linkedlist;

import java.util.*;

public class _138_copy_list_with_random_pointer {
    public Node copyRandomList(Node head) {

        Map<Node, Node> map = new HashMap<>();
        Node origHead = head;
        Node dummyHead = new Node(-1);
        Node prev = dummyHead;

        while(head != null) {
            prev.next = new Node(head.val);
            map.put(head, prev.next);
            head = head.next;
            prev = prev.next;
        }
        Node iterOrig = origHead;
        Node iterCur = dummyHead.next;
        while(iterCur != null) {
            iterCur.random = map.get(iterOrig.random);
            iterCur = iterCur.next;
            iterOrig = iterOrig.next;
        }
        return dummyHead.next;
    }
}

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
    }
}

