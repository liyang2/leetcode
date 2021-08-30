package trie;
import java.util.*;

public class _211_design_add_search_words_data_structure {
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
    public _211_design_add_search_words_data_structure() {
        root = new Node((char)0);
    }

    public void addWord(String word) {
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

    boolean searchInNode(String word, Node node) {
        Node head = node;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(ch == '.') {
                for(Node child : head.children.values()) {
                    if(searchInNode(word.substring(i+1), child)) return true;
                }
                return false;
            } else {
                if(head.children.containsKey(ch)) {
                    head = head.children.get(ch);
                } else {
                    return false;
                }
            }
        }
        return head.isLeaf;
    }

    public boolean search(String word) {
        return searchInNode(word, root);
    }
}
