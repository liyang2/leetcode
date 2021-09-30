package hashtable;
import java.util.*;
public class _460_LFU_cache {
}

class LFUCache {
    int capacity;
    Map<Integer, Node> map;
    Map<Integer, DLinkedList> useMap;
    int lowestUse = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        useMap = new HashMap<>();
    }

    private void updateUseMap(Node node) {
        int oldUse = node.use;
        int newUse = ++node.use;
        useMap.get(oldUse).remove(node);
        if(useMap.get(lowestUse).isEmpty()) {
            lowestUse++;
        }
        useMap.computeIfAbsent(newUse, o-> new DLinkedList()).add(node);
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            updateUseMap(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(capacity == 0) return;

        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            updateUseMap(node);
        } else {
            if(map.size() == capacity) {
                Node toDel = useMap.get(lowestUse).removeLast();
                map.remove(toDel.key);
            }

            Node node = new Node(key, value);
            map.put(key, node);
            useMap.computeIfAbsent(1, o->new DLinkedList()).add(node);
            lowestUse = 1;
        }
    }

    static class Node {
        int use = 1;
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    static class DLinkedList {
        Node head;
        Node tail;

        public DLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public boolean isEmpty() {
            return head.next == tail;
        }

        public Node removeLast() {
            Node toDel = tail.prev;
            remove(toDel);
            return toDel;
        }

        public void add(Node node) {
            remove(node);
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        public void remove(Node node) {
            if(node.next != null) {
                node.next.prev = node.prev;
            }
            if(node.prev != null) {
                node.prev.next = node.next;
            }
        }
    }
}




