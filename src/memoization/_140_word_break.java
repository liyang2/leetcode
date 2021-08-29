package memoization;

import java.util.*;

public class _140_word_break {
    Set<String> set;
    List<String>[] dp; //-1,uncalcuted,  0: false,  1: true

    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        dp = new ArrayList[s.length()];
        return wordBreakHelper(0, s);
    }

    List<String> wordBreakHelper(int start, String s) {
        if(start == s.length()) return Arrays.asList("");
        if(dp[start] != null) return dp[start];

        List<String> res = new ArrayList<>();

        for(int i = start+1; i <= s.length(); i++) {
            if(set.contains(s.substring(start, i))) {
                for(String str: wordBreakHelper(i, s)) {
                    String toAppend = str.isEmpty() ? "" : " " + str;
                    res.add(s.substring(start, i) + toAppend);
                }
            }
        }

        dp[start] = res;
        return res;
    }

    public static void main(String[] args) {
        new _140_word_break().wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog"));
    }
}
