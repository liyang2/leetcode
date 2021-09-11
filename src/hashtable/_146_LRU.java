package hashtable;

import java.util.*;

public class _146_LRU {

    static class Node{
        int key,val;
        Node prev,next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Node head;
    Node tail;
    int capacity;
    Map<Integer, Node> map;

    public _146_LRU(int capacity) {
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.next = head;
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insertAtFront(node);
            return node.val;
        }
        return -1;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtFront(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }

    public void put(int key, int value) {
        Node node = null;
        if(map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
            remove(node);
        } else {
            node = new Node(key, value);
        }
        map.put(key, node);
        insertAtFront(node);

        if(map.size() > capacity) {
            Node toRemove = tail.prev;
            remove(toRemove);
            map.remove(toRemove.key);
        }
    }

    public static void main(String[] args) {
        _146_LRU lru = new _146_LRU(2);
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
