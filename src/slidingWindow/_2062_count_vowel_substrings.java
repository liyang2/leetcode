package slidingWindow;
import java.util.*;

// 和992是一个题
public class _2062_count_vowel_substrings {
    public int countVowelSubstrings(String word) {
        return atMostK(word, 5) - atMostK(word, 4);
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' ||
                ch == 'u';
    }

    private int atMostK(String word, int k) {
        int l = 0, r = 0;
        int res = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        for (; r < word.length(); r++) {
            char ch = word.charAt(r);
            if (!isVowel(ch)) {
                l = r + 1;
                countMap.clear();
                continue;
            }
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
            while (countMap.size() > k) {
                char chL = word.charAt(l);
                countMap.put(chL, countMap.get(chL) - 1);
                if (countMap.get(chL) == 0) {
                    countMap.remove(chL);
                }
                l++;
            }
            res += r - (l - 1);
        }
        return res;
    }
}
