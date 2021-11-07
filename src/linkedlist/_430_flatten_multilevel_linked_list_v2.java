package linkedlist;

import java.util.*;

// This version uses constant space, but code is harder to read
public class _430_flatten_multilevel_linked_list_v2 {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node flatten(Node head) {
        return flatternHelper(head).get(0);
    }

    List<Node> flatternHelper(Node head) {
        Node node = head;
        Node tail = null;
        while (node != null) {
            Node next = node.next;
            tail = node;
            if (node.child != null) {
                List<Node> list = flatternHelper(node.child);
                node.child = null;
                node.next = list.get(0);
                list.get(0).prev = node;

                list.get(1).next = next;
                if (next != null) {
                    next.prev = list.get(1);
                } else {
                    tail = list.get(1);
                }
            }
            node = next;
        }
        return Arrays.asList(head, tail);
    }
}
