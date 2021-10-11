package slidingWindow;

/*
 This one is harder than most sliding windows problems, because it's not a great fit to use this technique
 unless you add another own constraint yourself: "at most h unique chars in the window"
 so that you know when to shrink the window, which is "unique > h"
 */
public class _395_longest_substring_with_at_least_k_repeating_characters {
    public int longestSubstring(String s, int k) {
        int res = 0;
        int totalUnique = totalUniqueChars(s);
        for(int h = 1; h <= totalUnique; h++) {
            int[] count = new int[26];
            int i = 0, j = 0;
            int unique = 0;
            int noLessThanK = 0;

            for(j = 0; j < s.length(); j++) {
                char chJ = s.charAt(j);
                if(count[chJ-'a'] == 0)
                    unique++;
                count[chJ-'a']++;
                if(count[chJ-'a'] == k)
                    noLessThanK++;

                while(i <= j && unique > h) {
                    char chI = s.charAt(i);
                    if(count[chI-'a'] == 1)
                        unique--;
                    if(count[chI-'a'] == k)
                        noLessThanK--;
                    count[chI-'a']--;
                    i++;
                }
                if(unique == h && unique == noLessThanK) {
                    res= Math.max(res, j - i+1);
                }
            }
        }
        return res;
    }

    int totalUniqueChars(String s) {
        int res = 0;
        int[] arr = new int[26];
        for(char ch: s.toCharArray()) {
            if(arr[ch-'a'] == 0)
                res++;
            arr[ch-'a']++;
        }
        return res;
    }
}
