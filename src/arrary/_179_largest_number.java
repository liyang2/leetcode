package arrary;
import java.util.*;
public class _179_largest_number {
    public String largestNumber(int[] nums) {
        nums = Arrays.stream(nums).boxed().sorted((o1, o2)-> {
            String str1 = String.valueOf(o1);
            String str2 = String.valueOf(o2);
            return (str2+str1).compareTo(str1+str2);

        }).mapToInt(n->n).toArray();
        StringBuilder sb = new StringBuilder();
        for(int n : nums) {
            if(sb.length() == 0 && n == 0) continue;
            sb.append(n);
        }
        if(sb.length() == 0) return "0";
        return sb.toString();
    }
}
