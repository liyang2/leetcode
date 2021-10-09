package graph.topologicalSort;
import java.util.*;
public class _269_alien_dictionary {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> map = new HashMap<>();
        int[] income = new int[26];
        int n = words.length;
        for(String w: words) {
            for(char ch: w.toCharArray()) {
                if(!map.containsKey(ch))
                    map.put(ch, new ArrayList<>());
            }
        }

        // build the adj List
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                int len = Math.min(words[i].length(), words[j].length());
                // special invalid case
                if(words[i].startsWith(words[j]) && words[i].length() > words[j].length())
                    return "";
                for(int k = 0; k < len; k++) {
                    char chI = words[i].charAt(k);
                    char chJ = words[j].charAt(k);
                    if(chI != chJ) {
                        map.get(chI).add(chJ);
                        income[chJ - 'a']++;
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for(char ch : map.keySet()) {
            if(income[ch - 'a'] == 0)
                q.add(ch);
        }
        while(!q.isEmpty()) {
            char ch = q.poll();
            sb.append(ch);
            for(char next : map.get(ch)) {
                income[next-'a']--;
                if(income[next-'a'] == 0) {
                    q.add(next);
                }
            }
        }
        if(sb.length() == map.size()) {
            return sb.toString();
        }
        return "";
    }
}
