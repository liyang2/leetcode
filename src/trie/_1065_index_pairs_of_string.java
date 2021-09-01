package trie;
import java.util.*;
public class _1065_index_pairs_of_string {
    TrieNode root = new TrieNode();

    public int[][] indexPairs(String text, String[] words) {
        for(String w: words) insert(w);
        List<int[]> list = new ArrayList<>();


        for(int i = 0; i < text.length(); i++) {
            TrieNode node = root;

            for(int j = i; j < text.length(); j++) {
                char ch = text.charAt(j);

                if(node.children.containsKey(ch)) {
                    node = node.children.get(ch);

                    if(node.isWord) {
                        list.add(new int[]{i, j});
                    }
                } else {
                    break;
                }
            }
        }
        int[][] res = new int[list.size()][2];
        list.toArray(res);
        return res;
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

    static class TrieNode{
        boolean isWord = false;
        Map<Character, TrieNode> children = new HashMap();
    }

}
