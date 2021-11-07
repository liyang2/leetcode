package sorting;
import java.util.*;
public class _451_sort_characters_by_frequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        };
        List<Character> charList = new ArrayList<>(map.keySet());
        Collections.sort(charList, (ch1, ch2) -> {
            return map.get(ch2) - map.get(ch1);
        });
        StringBuilder sb = new StringBuilder();
        for (char ch : charList) {
            int freq = map.get(ch);
            while (freq-- > 0) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
