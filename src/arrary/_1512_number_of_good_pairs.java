package arrary;
import java.util.*;
public class _1512_number_of_good_pairs {
    Map<Integer, Integer> map = new HashMap<>();

    public int numIdenticalPairs(int[] nums) {
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        int res = 0;
        for(int key : map.keySet()) {
            int val = map.get(key);
            res += val * (val-1) /2;
        }
        return res;
    }
}
