package string;

import java.util.*;

public class _953_verify_alien_dictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for(int i = 1; i < words.length; i++) {
            if(compare(words[i-1], words[i], map) > 0) {
                return false;
            }
        }
        return true;
    }

    int compare(String word1, String word2, Map<Character, Integer> map) {
        int len = Math.max(word1.length(), word2.length());
        for(int i = 0; i < len; i++) {
            int idx1 = i < word1.length() ? map.get(word1.charAt(i)) : -1;
            int idx2 = i < word2.length() ? map.get(word2.charAt(i)) : -1;
            if(idx1 != idx2) {
                return idx1 - idx2;
            }
        }
        return 0;
    }
}
