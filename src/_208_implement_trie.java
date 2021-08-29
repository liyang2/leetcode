import java.util.*;


class Trie {
    static class Node {
        char ch;
        boolean isLeaf = false;
        Map<Character, Node> children;

        public Node(char ch) {
            this.ch = ch;
            children = new HashMap<>();
        }
    }

    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node((char)0);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node head = root;
        for(char ch : word.toCharArray()) {
            if(head.children.containsKey(ch)) {
                head = head.children.get(ch);
            } else {
                Node newNode = new Node(ch);
                head.children.put(ch, newNode);
                head = newNode;
            }
        }
        head.isLeaf = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node head = root;
        for(char ch : word.toCharArray()) {
            if(head.children.containsKey(ch)) {
                head = head.children.get(ch);
            } else {
                return false;
            }
        }
        return head.isLeaf;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node head = root;
        for(char ch : prefix.toCharArray()) {
            if(head.children.containsKey(ch)) {
                head = head.children.get(ch);
            } else {
                return false;
            }
        }
        return true;
    }
}
