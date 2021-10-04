package stack;
import java.util.*;
public class _394_decode_string {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if(Character.isLetter(ch)) {
                sb.append(ch);
            } else if(ch == '[') {
                countStack.push(k);
                k = 0;
                stringStack.push(sb.toString());
                sb.delete(0, sb.length());
            } else if(ch == ']') {
                int curK = countStack.pop();
                String str = stringStack.pop() + repeat(sb.toString(), curK);
                sb.delete(0, sb.length());
                sb.append(str);
            }
        }

        return sb.toString();
    }

    String repeat(String pattern, int k) {
        StringBuilder sb = new StringBuilder();
        while(k-- > 0) {
            sb.append(pattern);
        }
        return sb.toString();
    }
}
