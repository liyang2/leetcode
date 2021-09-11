package string;

public class _696_count_binary_strings {
    // come up with two-pass solution which uses List<Integer> groups,
    // then try this one
    public int countBinarySubstrings(String s) {
        int curCount = 1;
        int prevCount = 0;
        int res = 0;

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                curCount ++;
            } else {
                res += Math.min(curCount, prevCount);
                prevCount = curCount;
                curCount = 1;
            }
        }
        res += Math.min(curCount, prevCount);

        return res;
    }
}
