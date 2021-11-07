package linkedlist;

import java.util.ArrayList;
import java.util.List;

// Code is easier to read, but use O(n) extra space
public class _430_flatten_multilevel_linked_list_v1 {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        List<Node> res = new ArrayList<>();
        flattenRecur(head, res);
        for (int i = 0; i < res.size() - 1; i++) {
            Node cur = res.get(i);
            Node next = res.get(i + 1);
            cur.next = next;
            next.prev = cur;
            cur.child = null;
            next.child = null;
        }
        return res.get(0);
    }

    void flattenRecur(Node head, List<Node> res) {
        if (head == null) {
            return;
        }
        Node node = head;
        while (node != null) {
            res.add(node);
            if (node.child != null) {
                flattenRecur(node.child, res);
            }
            node = node.next;
        }
    }
}
