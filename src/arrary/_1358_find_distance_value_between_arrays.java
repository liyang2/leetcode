package arrary;
import java.util.*;
public class _1358_find_distance_value_between_arrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int n : arr2) {
            set.add(n);
        }
        int res = 0;
        for(int n : arr1) {
            Integer ceiling = set.ceiling(n);
            Integer floor = set.floor(n);
            int diff = 0;
            if(ceiling == null) {
                diff = Math.abs(n - floor);
            } else if(floor == null) {
                diff = Math.abs(n - ceiling);
            } else {
                diff = Math.min(Math.abs(n - floor), Math.abs(n - ceiling));
            }
            if(diff > d) {
                res++;
            }
        }
        return res;
    }
}
