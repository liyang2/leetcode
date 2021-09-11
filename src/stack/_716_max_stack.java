package stack;

import java.util.*;

public class _716_max_stack {
    static class Node {
        int val;
        Node next;
        Node prev;
        public Node(int val) {this.val = val;}
    }
    TreeMap<Integer, LinkedList<Node>> treeMap;
    Node head;
    Node tail;

    /** initialize your data structure here. */
    public _716_max_stack() {
        treeMap = new TreeMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public void push(int x) {
        Node node = new Node(x);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next= node;
        tail.prev = node;

        LinkedList<Node> list = treeMap.getOrDefault(x, new LinkedList<>());
        list.addLast(node);
        treeMap.put(x, list);
    }

    public int pop() {
        int val = tail.prev.val;
        LinkedList<Node> list = treeMap.get(val);
        list.removeLast();
        if(list.isEmpty()) {
            treeMap.remove(val);
        }

        Node next = tail;
        Node prev = tail.prev.prev;
        prev.next = next;
        next.prev = prev;
        return val;
    }

    public int top() {
        return tail.prev.val;
    }

    public int peekMax() {
        return treeMap.lastKey();
    }

    public int popMax() {
        int key = treeMap.lastKey();
        LinkedList<Node> list = treeMap.get(key);
        Node node = list.getLast();
        list.removeLast();
        if(list.isEmpty()) {
            treeMap.remove(key);
        }

        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        return node.val;
    }
}
