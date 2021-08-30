package trie;
import java.util.*;

public class _1804_implement_trie_ii {
    static class Node {
        char ch;
        boolean isLeaf = false;
        Map<Character, Node> children;
        int countEquals = 0;
        int countStartsWith = 1;

        public Node(char ch) {
            this.ch = ch;
            children = new HashMap<>();
        }
    }

    Node root;

    public _1804_implement_trie_ii() {
        root = new Node((char)0);
    }

    public void insert(String word) {
        Node head = root;
        for(char ch : word.toCharArray()) {
            if(head.children.containsKey(ch)) {
                head = head.children.get(ch);
                head.countStartsWith++;
            } else {
                Node newNode = new Node(ch);
                head.children.put(ch, newNode);
                head = newNode;
            }
        }
        head.isLeaf = true;
        head.countEquals++;
    }

    public int countWordsEqualTo(String word) {
        Node head = root;
        for(char ch : word.toCharArray()) {
            if(head.children.containsKey(ch)) {
                head = head.children.get(ch);
            } else {
                return 0;
            }
        }
        return head.countEquals;
    }

    public int countWordsStartingWith(String prefix) {
        Node head = root;
        for(char ch : prefix.toCharArray()) {
            if(head.children.containsKey(ch)) {
                head = head.children.get(ch);
            } else {
                return 0;
            }
        }
        return head.countStartsWith;
    }

    public void erase(String word) {
        Node head = root;
        for(char ch : word.toCharArray()) {
            if(head.children.containsKey(ch)) {
                head = head.children.get(ch);
                if(head.countStartsWith > 0)
                    head.countStartsWith --;
            } else {
                return;
            }
        }
        if(head.countEquals > 0)
            head.countEquals--;
    }
}
