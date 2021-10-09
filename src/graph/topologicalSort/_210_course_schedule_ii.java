package graph.topologicalSort;
import java.util.*;

public class _210_course_schedule_ii {
    // typical topological sort DAG problem
    public int[] findOrder(int N, int[][] prerequisites) {
        int[] income = new int[N];
        List<List<Integer>> adjs = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            adjs.add(new ArrayList<>());
        }
        for(int[] p : prerequisites) {
            // should take p[1] before p[0], thus p[1] -> p[0]
            income[p[0]]++;
            adjs.get(p[1]).add(p[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            if(income[i] == 0)
                q.add(i);
        }
        int[] res = new int[N];
        int idx = 0;
        while(!q.isEmpty()) {
            int from = q.poll();
            res[idx++] = from;
            for(int to : adjs.get(from)) {
                income[to]--;
                if(income[to] == 0) {
                    q.add(to);
                }
            }
        }
        return idx == N ? res : new int[0];
    }
}
