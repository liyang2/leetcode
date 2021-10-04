package string;

public class _8_string_to_integer {
    public int myAtoi(String s) {
        s = s.trim();
        int sign = 1;
        if(s.isEmpty()) return 0;

        char first = s.charAt(0);
        if(first == '-') sign = -1;
        else if(first == '.' || (s.charAt(0) != '+' && !Character.isDigit(first))) return 0;

        int start = Character.isDigit(first) ? 0 : 1;
        long res = 0;
        for(int i = start; i < s.length(); i++) {
            if(!Character.isDigit(s.charAt(i))) {
                break;
            }
            res = res * 10 + s.charAt(i) - '0';

            if(res * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(res * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        res *= sign;

        return (int) res;
    }
}
