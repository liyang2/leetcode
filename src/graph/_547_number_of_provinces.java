package graph;

import java.util.HashSet;
import java.util.Set;

public class _547_number_of_provinces {
    int n;
    int[][] isConnected;
    public int findCircleNum(int[][] isConnected) {
        this.n = isConnected.length;
        this.isConnected = isConnected;
        int res = 0;
        Set<Integer> found = new HashSet<>();

        for(int i = 0; i < isConnected.length; i++) {
            if(!found.contains(i)) {
                res++;
                dfs(i, found);
            }
        }
        return res;
    }

    void dfs(int i, Set<Integer> found) {
        found.add(i);
        for(int neighbor = 0; neighbor < n; neighbor++) {
            if(isConnected[i][neighbor] == 1 && !found.contains(neighbor)) {
                found.add(neighbor);
                dfs(neighbor, found);
            }
        }
    }
}
