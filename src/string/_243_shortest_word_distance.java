package string;

public class _243_shortest_word_distance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int idx1 = -1, idx2 = -1;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < wordsDict.length; i++) {
            if(word1.equals(wordsDict[i])) {
                idx1 = i;
            }

            if(word2.equals(wordsDict[i])) {
                idx2 = i;
            }
            if(idx1 != -1 && idx2 != -1) {
                res = Math.min(res, Math.abs(idx1 - idx2));
            }
        }
        return res;
    }
}
