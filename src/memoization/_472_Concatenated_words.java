package memoization;

import java.util.*;

public class _472_Concatenated_words {
    Set<String> set;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        set = new HashSet<>();
        for(String w: words) {
            set.add(w);
        }

        for(String word: words) {
            if(word.isEmpty()) continue;
            int[] dp = new int[word.length()+1];
            Arrays.fill(dp, -1); // 0 : false, 1: true
            set.remove(word);
            if(checkWord(word, 0, dp)) {
                res.add(word);
            }
            set.add(word);
        }
        return res;
    }

    // checks whether word[start:] can be concated from two strings
    boolean checkWord(String word, int start, int[] dp) {
        if(set.isEmpty()) return false;
        if(start == word.length()) return true;
        if(dp[start] != -1) return dp[start] == 0 ? false : true;

        for(int len = 1; start + len <= word.length(); len++) {
            if(set.contains(word.substring(start, start+len)) &&
                    checkWord(word, start+len, dp)){
                dp[start] = 1;
                return true;
            }
        }
        dp[start] = 0;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(
        new _472_Concatenated_words().
                findAllConcatenatedWordsInADict(
                        new String[]{"cat","cats",
                                "catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
    }
}
