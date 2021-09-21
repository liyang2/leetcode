package math;
import java.util.*;
public class _2013_detect_squares {
    Map<Integer, Integer> map = new HashMap<>();

    public void add(int[] point) {
        int idx = point[0]*1001+point[1];
        map.put(idx, map.getOrDefault(idx, 0)+1);
    }

    public int count(int[] point) {
        int res = 0;
        for(int key: map.keySet()) {
            int y = key % 1001;
            int x = key/ 1001;
            if(x == point[0] || y == point[1]) continue;

            if(Math.abs(x - point[0]) == Math.abs(y - point[1])) {
                int[] p1 = {point[0], y};
                int[] p2 = {x, point[1]};
                int count1 = map.getOrDefault(p1[0] * 1001+p1[1], 0);
                int count2 = map.getOrDefault(p2[0] * 1001+p2[1], 0);
                int count3 = map.get(key);
                res += count1 * count2 * count3;
            }
        }
        return res;
    }
}
