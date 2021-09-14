package string;

import java.util.HashMap;
import java.util.*;

public class _290_word_pattern {
    public boolean wordPattern(String pattern, String s) {
        String[] parts = s.split(" ");
        if(parts.length != pattern.length()) return false;

        Map<Character, String> map = new HashMap<>();
        Set<String> mapped = new HashSet<>();
        for(int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if(!map.containsKey(ch)) {
                if(mapped.contains(parts[i]))
                    return false;
                map.put(ch, parts[i]);
                mapped.add(parts[i]);
            } else {
                if(!map.get(ch).equals(parts[i])) return false;
            }
        }
        return true;
    }
}
