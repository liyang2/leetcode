package hashtable;
import java.util.*;
public class _1002_find_common_characters {
    public List<String> commonChars(String[] words) {
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for(String str: words) {
            int[] curCount = new int[26];
            for(char ch : str.toCharArray()) {
                curCount[ch-'a']++;
            }
            for(int i = 0; i < 26;i++) {
                count[i] = Math.min(count[i], curCount[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i < 26;i++) {
            for(int j = 0; j < count[i]; j++) {
                char ch = (char)('a'+i);
                res.add(""+ch);
            }
        }
        return res;
    }
}
