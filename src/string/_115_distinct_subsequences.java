package string;
import java.util.*;
public class _115_distinct_subsequences {
    Map<String, Integer> map = new HashMap<>();

    public int numDistinct(String s, String t) {
        return recur(s, t, 0, 0);
    }

    int recur(String s, String t, int i, int j) {
        if(i == s.length() || j == t.length() || s.length()-i < t.length()-j){
            return j == t.length() ? 1 : 0;
        }
        String key = i+"-"+j;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        int res = 0;
        res = recur(s, t, i+1, j);
        if(s.charAt(i) == t.charAt(j)){
            res += recur(s, t, i+1, j+1);
        }
        map.put(key, res);
        return res;
    }
}
