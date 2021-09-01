package trie;

import java.util.*;

public class _642_design_search_auto_complete_system {
    static class TrieNode{
        Map<Character, TrieNode> children = new TreeMap<>();
        int weight = -1;
    }

    TrieNode root = new TrieNode();

    public _642_design_search_auto_complete_system(String[] sentences, int[] times) {
        for(int i = 0; i < times.length; i++) {
            insert(sentences[i], times[i]);
        }
    }

    void insert(String word, int weight) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            if(!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        if(node.weight == -1) {
            node.weight++;
        }
        node.weight += weight;
    }

    StringBuilder sb = new StringBuilder();

    public List<String> input(char c) {
        if(c == '#') {
            insert(sb.toString(), 1);
            sb = new StringBuilder();
            return new ArrayList<>();
        }
        sb.append(c);
        String prefix = sb.toString();
        TrieNode node = root;
        for(char ch : prefix.toCharArray()) {
            if(node.children.containsKey(ch)) {
                node = node.children.get(ch);
            } else {
                return new ArrayList<>();
            }
        }
        PriorityQueue<Item> q = new PriorityQueue<>((o1, o2)-> {
            if(o1.weight != o2.weight) {
                return o1.weight - o2.weight;
            } else {
                return o2.text.compareTo(o1.text);
            }
        });
        dfs(node, q, prefix);

        List<String> res = new ArrayList<>();
        while(!q.isEmpty()) {
            res.add(q.poll().text);
        }
        Collections.reverse(res);
        return res;
    }

    void dfs(TrieNode node, PriorityQueue<Item> q, String str) {
        if(node.weight != -1) {
            Item item = new Item(str, node.weight);
            q.add(item);
            if(q.size() > 3) q.poll();
        }
        for(Map.Entry<Character, TrieNode> entry: node.children.entrySet()) {
            char ch = entry.getKey();
            TrieNode child = entry.getValue();
            dfs(child, q, str + ch);
        }
    }

    static class Item {
        String text;
        int weight;
        public Item(String text, int weight) {
            this.text = text;
            this.weight = weight;
        }
    }
}
