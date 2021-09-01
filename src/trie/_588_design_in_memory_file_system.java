package trie;
import java.util.*;
public class _588_design_in_memory_file_system {
    static class TrieNode{
        String fileContents ="";
        boolean isFile = false;
        Map<String, TrieNode> children = new TreeMap();
    }

    TrieNode root;

    public _588_design_in_memory_file_system() {
        root = new TrieNode();
    }

    public List<String> ls(String path) {
        String[] parts = path.split("/");
        TrieNode node = root;
        for(int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if(node.children.containsKey(part)) {
                node = node.children.get(part);
            } else {
                return new ArrayList<>();
            }
        }
        if(node.isFile)
            return Arrays.asList(parts[parts.length-1]);

        List<String> res = new ArrayList<>();
        for(String child : node.children.keySet()) {
            res.add(child);
        }
        return res;
    }


    public void mkdir(String path) {
        String[] parts = path.split("/");
        TrieNode node = root;
        for(int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if(!node.children.containsKey(part)) {
                node.children.put(part, new TrieNode());
            }
            node = node.children.get(part);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] parts = filePath.split("/");
        TrieNode node = root;
        for(int i = 1; i < parts.length; i++) {
            String part = parts[i];
            if(!node.children.containsKey(part)) {
                node.children.put(part, new TrieNode());
            }
            node = node.children.get(part);
        }
        node.isFile = true;
        node.fileContents += content;
    }

    public String readContentFromFile(String filePath) {
        String[] parts = filePath.split("/");
        TrieNode node = root;
        for(int i = 1; i < parts.length; i++) {
            String part = parts[i];
            node = node.children.get(part);
        }
        return node.fileContents;
    }
}
