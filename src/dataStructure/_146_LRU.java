package dataStructure;

import java.util.*;

public class _146_LRU {}

class LRUCache {
    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node();
    Node tail = new Node();
    /*
     * @param capacity: An integer
     */public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void moveToFront(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;

        addNewNode(node);
    }

    private Node removeLast() {
        Node last = tail.prev;
        tail.prev = last.prev;
        last.prev.next = tail;
        return last;
    }

    private void addNewNode(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToFront(node);
            return node.val;
        }
        return -1;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToFront(node);
            node.val = value;
        } else {
            if (map.size() == capacity) {
                Node lastNode = removeLast();
                map.remove(lastNode.key);
            }
            Node newNode = new Node(key, value);
            addNewNode(newNode);
            map.put(key, newNode);
        }
    }
}

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node() {}

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
