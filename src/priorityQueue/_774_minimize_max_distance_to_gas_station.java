package priorityQueue;

import java.util.*;

public class _774_minimize_max_distance_to_gas_station {
    public static void main(String[] args) {
        int[] arr = {10,19,25,27,56,63,70,87,96,97};
        new _774_minimize_max_distance_to_gas_station().minmaxGasDist(arr, 3);

    }
    public double minmaxGasDist(int[] stations, int K) {
        int N = stations.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) ->
                (double)b[0]/b[1] < (double)a[0]/a[1] ? -1 : 1);
        for (int i = 0; i < N-1; ++i)
            pq.add(new int[]{stations[i+1] - stations[i], 1});

        for (int k = 0; k < K; ++k) {
            int[] node = pq.poll();
            node[1]++;
            pq.add(node);
        }

        int[] node = pq.poll();
        return (double)node[0] / node[1];
    }
}
