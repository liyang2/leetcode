package priorityQueue;
import java.util.*;
public class _1167_min_cost_to_connect_sticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int n : sticks) {
            q.add(n);
        }
        int res = 0;
        while(q.size() > 1) {
            int sum = q.poll() + q.poll();
            res += sum;
            q.add(sum);
        }
        return res;
    }
}
