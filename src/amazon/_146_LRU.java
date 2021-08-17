package amazon;

import java.util.*;

public class _146_LRU {

    static class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;
    }

    Map<Integer, ListNode> map = new HashMap<>();
    int capacity;
    ListNode head, tail;
    int size;

    public _146_LRU(int capacity) {
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.next = head;
    }

    void moveToHead(ListNode node) {
        if(node.prev != null && node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.next = head.next;
        node.prev = head;

        node.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            moveToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    void removeTail() {
        ListNode n = tail.prev;
        map.remove(n.key);
        n.prev.next = tail;
        tail.prev = n.prev;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            if(size == capacity) {
                removeTail();
                size--;
            }
            ListNode node = new ListNode();
            node.key = key;
            node.val = value;
            moveToHead(node);
            map.put(key, node);
            size++;
        }
    }

    public static void main(String[] args) {
    }
}
