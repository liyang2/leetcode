package backtrack;
import java.util.*;
public class _1239_max_length_of_concatenated_string_with_unique_chars {
    int[] arr = new int[26];
    public int maxLength(List<String> list) {
        return recur(list, 0);
    }

    int recur(List<String> list, int index) {
        if(index== list.size())
            return 0;

        int res = recur(list, index+1);
        String str = list.get(index);
        boolean skipCurrent = false;
        for(char ch : str.toCharArray()) {
            if(arr[ch - 'a'] > 0) {
                skipCurrent = true;
            }
            arr[ch-'a']++;
        }
        if(!skipCurrent) {
            res = Math.max(res, str.length() + recur(list, index+1));
        }
        //backtrack
        for(char ch : str.toCharArray()) {
            arr[ch-'a']--;
        }
        return res;
    }
}
