package arrary;
import java.util.*;
public class _1636_sort_array_by_increasing_frequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Arrays.stream(nums).forEach(n -> count.put(n, count.getOrDefault(n, 0)+1));
        return Arrays.stream(nums).boxed().sorted((a,b)->{
            if(count.get(a) == count.get(b)) {
                return b - a;
            } else {
                return count.get(a) - count.get(b);
            }
        }).mapToInt(n->n).toArray();

    }
}
