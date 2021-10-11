package trie;
import java.util.*;

public class _212_word_search_ii {

    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        new _212_word_search_ii().findWords(board, words);
    }
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        String word = null;
        public TrieNode() {}
    }
    List<String> res = new ArrayList<>();
    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        for(String word : words) {
            TrieNode node = root;
            for(char ch : word.toCharArray()) {
                if(!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
            }
            node.word = word;
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(root.children.containsKey(board[i][j])) {
                    dfs(board, i, j, root);
                }
            }
        }
        return res;
    }

    int[][] dirs = {{1, 0}, {-1,0}, {0,1}, {0,-1}};
    void dfs(char[][] board, int i, int j, TrieNode parent) {
        TrieNode cur = parent.children.get(board[i][j]);
        if(cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }
        char copy = board[i][j];
        board[i][j] = '#';
        for(int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if(nextI >= 0 && nextI < board.length && nextJ >= 0 && nextJ < board[0].length
                    && board[nextI][nextJ] != '#' && cur.children.containsKey(board[nextI][nextJ])) {
                dfs(board, nextI, nextJ, cur);
            }
        }
        board[i][j] = copy;
    }
}
