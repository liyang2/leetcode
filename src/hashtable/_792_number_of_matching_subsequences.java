package hashtable;

import java.util.*;

public class _792_number_of_matching_subsequences {
    public int numMatchingSubseq(String s, String[] words) {
        ArrayList[] buckets = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            buckets[i] = new ArrayList<Node>();
        }
        for (String word : words) {
            buckets[word.charAt(0) - 'a'].add(new Node(word, 0));
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            ArrayList<Node> bucket = buckets[ch - 'a'];
            buckets[ch - 'a'] = new ArrayList<Node>();
            for (Node node : bucket) {
                node.index++;
                if (node.index == node.word.length()) {
                    res++;
                } else {
                    buckets[node.word.charAt(node.index) - 'a'].add(node);
                }
            }
            bucket.clear(); // instead of remove() for each node because remove() takes O(n)
        }
        return res;
    }
}

class Node {
    int index;
    String word;
    public Node(String word, int index) {
        this.word = word;
        this.index = index;
    }
}
