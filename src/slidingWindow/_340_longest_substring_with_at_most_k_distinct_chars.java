package slidingWindow;
import java.util.*;
public class _340_longest_substring_with_at_most_k_distinct_chars {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();
        int counter = 0;
        int res = 0;
        for(r = 0; r < s.length(); r++) {
            char chR = s.charAt(r);
            map.put(chR, map.getOrDefault(chR, 0)+1);
            if(map.get(chR) == 1) {
                counter++;
            }
            // window is broken inside while loop
            // we try to fix it by l++
            while(l <= r && counter > k) {
                char chL = s.charAt(l++);
                map.put(chL, map.get(chL)-1);
                if(map.get(chL) == 0)
                    counter--;
            }
            res = Math.max(res, r - l +1);
        }
        return res;
    }
}
