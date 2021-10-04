package dataStructure;

import java.util.*;

public class _146_LRU {}



class LRUCache {
    static class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            moveToFront(node);
            return node.val;
        }
        return -1;
    }

    private void moveToFront(Node node) {
        deleteNode(node);
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }

    private void deleteNode(Node node) {
        if(node.prev != null)
            node.prev.next = node.next;
        if(node.next != null)
            node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            moveToFront(node);
            node.val = value;
        } else {
            Node node = new Node(key, value);
            moveToFront(node);
            map.put(key, node);

            if(map.size() > capacity) {
                Node toDel = tail.prev;
                deleteNode(toDel);
                map.remove(toDel.key);
            }
        }
    }


    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1,0);
        lru.put(2,2);
        lru.get(1);
        lru.put(3,3);
        lru.get(2);
        lru.put(4,4);
        lru.get(1);
        lru.get(3);
        lru.get(4);
    }
}
