package trie;
import java.util.*;
public class _212_word_search_ii {

    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        new _212_word_search_ii().findWords(board, words);
    }

    boolean[][] used;
    char[][] board;
    int[][] dirs = {{0, 1}, {0, -1}, {1,0}, {-1,0}};
    int m,n;
    List<String> res;
    Trie trie = new Trie();

    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<>();
        for(String word: words) trie.insert(word);
        this.board = board;
        m = board.length;
        n = board[0].length;
        used = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(i, j, new StringBuilder());
            }
        }
        return res;
    }


    // ask yourself this question:
    // at the begging of the method, is board[i][j] counted already, answer is no for this one
    void dfs(int i, int j, StringBuilder sb) {
        if(trie.search(sb.toString())) {
            res.add(sb.toString());
            return;
        }

        if(i < 0 || j < 0 || i >= m || j >= n || used[i][j] ||
                !trie.startsWith(sb.toString())) return;

        used[i][j] = true;
        sb.append(board[i][j]);

        for(int[] dir: dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            dfs(newI, newJ, sb);
        }

        used[i][j] = false;
        sb.deleteCharAt(sb.length()-1);
    }

    static class Node {
        char ch;
        boolean isLeaf = false;
        Map<Character, Node> children;

        public Node(char ch) {
            this.ch = ch;
            children = new HashMap<>();
        }
    }

    static class Trie {
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
}
