package string;
import java.util.*;
public class _1694_reformat_phone_number {
    public String reformatNumber(String number) {
        List<Character> list = new ArrayList<>();
        for(char ch: number.toCharArray()) {
            if(!Character.isDigit(ch)) continue;
            else list.add(ch);
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < list.size()) {
            if(i <= list.size()-3 && i != list.size()-4 ) {
                sb.append(str(list.subList(i, i+3))+"-");
                i += 3;
            } else if(i == list.size()-4) {
                sb.append(str(list.subList(i, i+2))+"-");
                sb.append(str(list.subList(i+2, i+4)));
                i += 4;
            } else { // i > list.size()-3
                sb.append(str(list.subList(i, list.size())));
                i = list.size();
            }
        }
        if(sb.charAt(sb.length()-1) == '-')
            sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    String str(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        for(char ch : list) sb.append(ch);
        return sb.toString();
    }
}
