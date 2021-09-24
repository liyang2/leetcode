package graph;
import java.util.*;
public class _127_word_ladder {
    public static void main(String[] args) {
        new _127_word_ladder().ladderLength("hit", "cog",
                Arrays.asList("hot","dot","dog","lot","log","cog"));
    }


    Set<String> set;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        set = new HashSet<>(wordList);
        int res = 1;
        Queue<String> q = new LinkedList<>();
        Set<String> used = new HashSet<>();
        q.add(beginWord);
        used.add(beginWord);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String word = q.poll();
                for(String next: nextWords(word)) {
                    if(next.equals(endWord))
                        return res+1;
                    if(!used.contains(next)) {
                        used.add(next);
                        q.add(next);
                    }
                }
            }
            res++;
        }
        return 0;
    }

    List<String> nextWords(String word) {
        List<String> list = new ArrayList<>();
        char[] arr = word.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            char orig = arr[i];
            for(char ch = 'a'; ch <= 'z'; ch++) {
                if(ch != orig) {
                    arr[i] = ch;
                    String str = new String(arr);
                    if(set.contains(str)) {
                        list.add(str);
                    }
                }
            }
            arr[i] = orig;
        }
        return list;
    }
}
