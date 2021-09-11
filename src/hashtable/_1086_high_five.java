package hashtable;
import java.util.*;
public class _1086_high_five {
    public int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> scores = new HashMap<>();
        for(int[] item: items) {
            if(!scores.containsKey(item[0])) {
                scores.put(item[0], new ArrayList<>());
            }
            scores.get(item[0]).add(item[1]);
        }
        int[][] res = new int[scores.size()][2];
        int idx = 0;

        for(int id : scores.keySet()) {
            List<Integer> list = scores.get(id);
            Collections.sort(list,  Collections.reverseOrder());
            int sum = 0;
            for(int i = 0; i < 5; i++) {
                sum += list.get(i);
            }
            sum /= 5;
            res[idx++] = new int[]{id, sum};
        }
        Arrays.sort(res, (o1, o2)->Integer.compare(o1[0], o2[0]));
        return res;
    }
}
