package backtrack;
import java.util.*;
// huge runtime difference between this solution and bitmask DP solution
// but as always, DP solution is hard to come up
public class _2002_max_product_of_length_palindromic_subsequences {
    String s;
    Map<String, Integer> map = new HashMap<>();

    public int maxProduct(String s) {
        this.s = s;
        return dfs(0, "", "");
    }

    int dfs(int i, String s1, String s2) {
        String key = i+"_"+s1 +"_"+s2;
        if(map.containsKey(key)) {
            return map.get(key);
        }

        int res = 0;
        if(i >= s.length()) {
            if(isPalin(s1) && isPalin(s2)) {
                return s1.length() * s2.length();
            }
            return 0;
        }
        res = Math.max(res, dfs(i+1, s1+s.charAt(i), s2));
        res = Math.max(res, dfs(i+1, s1, s2+s.charAt(i)));
        res = Math.max(res, dfs(i+1, s1, s2));

        map.put(key, res);
        return res;
    }

    boolean isPalin(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
