package trie;
import java.util.*;
public class _1858_longest_word_with_all_prefixes {
    static class TrieNode{
        boolean isWord = false;
        Map<Character, TrieNode> children = new HashMap();
    }
    TrieNode root = new TrieNode();

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for(String w : words) insert(w);
        String res = "";

        for(String word : words) {
            if(exists(word)) {
                if(word.length() > res.length() ||
                        (word.length() == res.length() && word.compareTo(res) < 0)) {
                    res = word;
                }
            }
        }
        return res;
    }

    public boolean exists(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            if(!node.children.containsKey(ch)) {
                return false;
            } else {
                node = node.children.get(ch);
                if(!node.isWord) return false;
            }
        }
        return true;
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            if(!node.children.containsKey(ch))
                node.children.put(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isWord = true;
    }
}
