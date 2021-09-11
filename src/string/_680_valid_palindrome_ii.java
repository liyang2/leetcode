package string;

public class _680_valid_palindrome_ii {
    public boolean validPalindrome(String s) {
        return valid(s, 0, s.length()-1, false);
    }

    boolean valid(String s, int start, int end, boolean flag) {
        if(start >= end) return true;

        if(s.charAt(start) == s.charAt(end)) {
            return valid(s, start+1, end-1, flag);
        } else if(!flag) {
            return valid(s, start+1, end, true) || valid(s, start, end-1, true);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        new _680_valid_palindrome_ii().validPalindrome("eeccccbebaeeabebccceea");
    }
}
