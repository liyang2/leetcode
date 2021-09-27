package string;

import java.util.Arrays;

public class _828_count_unique_chars_of_all_substrings {
    public int uniqueLetterString(String s) {
        int[][] index = new int[26][2];
        for(int[] arr: index)
            Arrays.fill(arr, -1);

        int n = s.length();
        int res = 0;
        for(int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';
            res += (i - index[c][1]) * (index[c][1] - index[c][0]);
            index[c][0] = index[c][1];
            index[c][1] = i;
        }
        for(int c = 0; c < 26; c++) {
            res += (n - index[c][1]) * (index[c][1] - index[c][0]);
        }
        return res;
    }
}
