package string;

public class _1758_minimum_changes_to_make_alternate_binary_string {
    public int minOperations(String s) {
        int res1 = 0, res2 = 0;
        char prev1 = '1', prev2 = '0';
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == prev1) {
                res1++;
            } else if(s.charAt(i) == prev2) {
                res2++;
            }
            prev1 = alt(prev1);
            prev2 = alt(prev2);
        }

        return Math.min(res1, res2);
    }


    char alt(char ch) {
        return ch == '1' ? '0' : '1';
    }
}
