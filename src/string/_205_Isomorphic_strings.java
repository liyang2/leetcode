package string;
import java.util.*;

public class _205_Isomorphic_strings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();// contains chars in 't' that has a mapping in 's'

        for(int i = 0; i < s.length(); i++) {
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);
            if(!map.containsKey(sCh)) {
                if(used.contains(tCh)) return false;
                map.put(sCh, tCh);
                used.add(tCh);
            } else if(!map.get(sCh).equals(tCh)) {
                return false;
            }
        }
        return true;
    }
}
