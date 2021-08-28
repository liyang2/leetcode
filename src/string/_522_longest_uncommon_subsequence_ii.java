package string;
import java.util.*;
public class _522_longest_uncommon_subsequence_ii {
    // problem reduced to find a string among an array which is not subsequence of the rest
    // note: when talking about subsequence, foo(a, b) is different than foo(b, a)
    public int findLUSlength(String[] strs) {
        int res = -1;
        Arrays.sort(strs, (o1, o2) -> o2.length() - o2.length());

        for(int i = 0; i < strs.length; i++) {
            boolean isSub = false;
            for(int j = 0; j < strs.length; j++) {
                if(j!= i && isSubsequence(strs[i], strs[j])) {
                    isSub = true;
                    break;
                }
            }
            if(!isSub) {
                res = Math.max(res, strs[i].length());
            }
        }
        return res;
    }

    // if x is subsequence of y
    boolean isSubsequence(String x, String y) {
        if(x.length() > y.length()) return false;
        int i = 0;
        for(int j = 0;i < x.length() && j < y.length() ; j++) {
            if(x.charAt(i) == y.charAt(j)) {
                i++;
            }
        }
        return x.length() == i;
    }
}
