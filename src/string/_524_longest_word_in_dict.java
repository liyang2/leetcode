package string;

import java.util.List;

public class _524_longest_word_in_dict {
    String res = "";

    public String findLongestWord(String s, List<String> dictionary) {
        for(String word : dictionary) {
            if(isSubsequence(word, s)) {
                if(word.length() > res.length() || (word.length() == res.length() && word.compareTo(res) < 0)) {
                    res = word;
                }
            }
        }

        return res;
    }

    boolean isSubsequence(String x, String y) {
        int i = 0;
        for(int j = 0; i < x.length()&&j < y.length(); j++) {
            if(x.charAt(i) == y.charAt(j)) {
                i++;
            }
        }
        return i == x.length();
    }
}
