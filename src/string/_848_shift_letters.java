package string;

public class _848_shift_letters {
    public static void main(String[] args) {
        new _848_shift_letters().shiftingLetters("abc", new int[]{3, 5, 9});
    }
    public String shiftingLetters(String s, int[] shifts) {
        for(int i = shifts.length-2; i >= 0; i--) {
            shifts[i+1] %= 26;
            shifts[i] %= 26;
            shifts[i] += shifts[i+1];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            sb.append(shiftChar(s.charAt(i), shifts[i]));
        }
        return sb.toString();
    }

    char shiftChar(char ch, int n) {
        int idx = ch - 'a';
        idx = (idx + n) % 26;
        return (char) ('a'+idx);
    }
}
