package slidingWindow;
import java.util.*;
public class _3_longest_substring_without_repeating_chars {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        int res = 0;
        Map<Character, Integer> count = new HashMap<>();
        for(r= 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            count.put(ch, count.getOrDefault(ch, 0)+1);
            while(l <= r && count.get(ch) > 1) {
                char chL = s.charAt(l);
                count.put(chL, count.get(chL)-1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
