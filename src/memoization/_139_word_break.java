package memoization;

import java.util.*;

public class _139_word_break {
    Set<String> set;
    int[] dp; //-1,uncalcuted,  0: false,  1: true

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return wordBreakHelper(0, s);
    }

    boolean wordBreakHelper(int start, String s) {
        if(start == s.length()) return true;
        if(dp[start] != -1) return dp[start] == 0 ? false : true;

        boolean res = false;
        for(int i = start+1; i <= s.length(); i++) {
            if(set.contains(s.substring(start, i)) && wordBreakHelper(i, s)) {
                res = true;
                break;
            }
        }
        dp[start] = res ? 1 : 0;
        return res;
    }
}
