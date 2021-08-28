package priorityQueue;

import java.util.*;

public class _973_k_closest_points {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            int x1 = o1[0];
            int y1 = o1[1];
            int x2 = o2[0];
            int y2 = o2[1];
            return Integer.compare(x2 * x2 + y2 * y2, x1 * x1 + y1 * y1);
        });
        for(int[] point : points) {
            q.add(point);
            if(q.size() > k) q.poll();
        }
        int[][] res = new int[k][2];
        q.toArray(res);
        return res;
    }
}
