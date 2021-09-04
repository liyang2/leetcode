package string;

public class _125_valid_palindrome {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            char chi = Character.toLowerCase(s.charAt(i++));
            char chj = Character.toLowerCase(s.charAt(j--));
            if(chi != chj)
                return false;
        }
        return true;
    }
}
