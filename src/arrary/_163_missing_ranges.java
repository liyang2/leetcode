package arrary;
import java.util.*;
public class _163_missing_ranges {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {

        List<String> res = new ArrayList<>();
        if(A.length == 0) {
            int start= lower, end = upper;
            if(start == end) res.add(start+"");
            else res.add(start + "->" + end);
            return res;
        }

        if(A[0] > lower) {
            int start = lower;
            int end = A[0]-1;
            if(start == end) res.add(start+"");
            else res.add(start + "->" + end);
        }

        for(int i = 1; i < A.length; i++) {
            if(A[i] > A[i-1]+1) {
                int start = A[i-1]+1;
                int end = A[i]-1;
                if(start == end) res.add(start+"");
                else res.add(start + "->" + end);
            }
        }
        if(A[A.length-1] < upper) {
            int start = A[A.length-1]+1;
            int end = upper;
            if(start == end) res.add(start+"");
            else res.add(start + "->" + end);
        }


        return res;
    }
}
