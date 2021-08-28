package memoization;

import java.util.*;

public class _97_interleaving_string {
    int[][] memo; // 3 states: -1 is uncalculated, 0 is false, 1 is true

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;

        memo = new int[s1.length()+1][s2.length()+1];
        for(int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return isInterleaveHelper(s1, s2, s3, 0, 0) == 1;
    }

    private int isInterleaveHelper(String s1, String s2, String s3, int idx1,
                                   int idx2) {
        int idx3 = idx1 + idx2;
        if(idx3 == s3.length()) return 1;
        if(memo[idx1][idx2] != -1) return memo[idx1][idx2];

        if(idx1 < s1.length() &&
                s1.charAt(idx1) == s3.charAt(idx3) &&
                isInterleaveHelper(s1, s2, s3, idx1+1, idx2) == 1) {
            memo[idx1][idx2] = 1;
        }
        else if(idx2 < s2.length() &&
                s2.charAt(idx2) == s3.charAt(idx3) &&
                isInterleaveHelper(s1, s2, s3, idx1, idx2+1) == 1) {
            memo[idx1][idx2] = 1;

        } else {
            memo[idx1][idx2] = 0;
        }
        return memo[idx1][idx2];
    }
}
