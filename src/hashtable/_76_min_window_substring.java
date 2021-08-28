package hashtable;

import java.util.*;

public class _76_min_window_substring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0)+1);
        }
        int formed = 0;
        int i = 0;
        int[] ans = {Integer.MAX_VALUE, 0, -1}; // length, left, right

        for(int j = 0; j < s.length(); j ++) {
            char ch = s.charAt(j);
            sMap.put(ch, sMap.getOrDefault(ch, 0)+1);

            /// Be very care here, because sMap.get(ch) is Integer and not int, Integer == Integer is dangerous
            if(tMap.containsKey(ch) && sMap.get(ch).equals(tMap.get(ch))) {
                formed ++;
                while (formed == tMap.size()) {
                    int curLen = j - i + 1;
                    if(curLen < ans[0]) {
                        ans[0] = curLen;
                        ans[1] = i;
                        ans[2] = j;
                    }

                    char chI = s.charAt(i);
                    sMap.put(chI, sMap.get(chI)-1);
                    if(tMap.containsKey(chI) && tMap.get(chI).intValue() > sMap.get(chI).intValue()) {
                        formed--;
                    }
                    i++;

                }
            }
        }
        return s.substring(ans[1], ans[2]+1);
    }
}
