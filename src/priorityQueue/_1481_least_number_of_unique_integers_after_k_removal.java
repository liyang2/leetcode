package priorityQueue;

import java.util.*;

public class _1481_least_number_of_unique_integers_after_k_removal {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int n : arr) {
            counts.put(n, counts.getOrDefault(n, 0)+1);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2)-> {
            return o1[1] - o2[1];
        });
        for(int n : counts.keySet()) {
            q.add(new int[] {n, counts.get(n)});
        }
        while(!q.isEmpty() &&  q.peek()[1] <= k) {
            k -= q.poll()[1];
        }
        return q.size();
    }
}
