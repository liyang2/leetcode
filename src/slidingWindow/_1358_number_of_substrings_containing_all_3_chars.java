package slidingWindow;

// this one is special because it's "at least" not "at most"
public class _1358_number_of_substrings_containing_all_3_chars {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int counter = 0;
        int l = 0, r = 0;
        int res = 0;
        for(r = 0;r < s.length(); r++) {
            count[s.charAt(r)-'a']++;
            if(count[s.charAt(r)-'a'] == 1) {
                counter++;
            }

            // windows is formed inside while loop
            // we try to break it with l++
            while(counter == 3 && l <= r) {
                res += s.length()-r;

                char ch0 = s.charAt(l);
                if(--count[ch0-'a'] == 0) {
                    counter--;
                }
                l++;
            }
        }
        return res;
    }
}
