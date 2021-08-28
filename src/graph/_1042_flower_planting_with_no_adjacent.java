package graph;

import java.util.*;

public class _1042_flower_planting_with_no_adjacent {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] res = new int[n];


        // build adjList
        List<Integer>[] adjList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) adjList[i] = new ArrayList<>();

        for(int[] path: paths) {
            adjList[path[0]].add(path[1]);
            adjList[path[1]].add(path[0]);
        }


        for(int i = 1; i <= n; i++) {
            Set<Integer> neighborColors = new HashSet<>();
            for(int neighbor : adjList[i]) {
                neighborColors.add(res[neighbor-1]);
            }
            for(int color = 1; color <= 4; color++) {
                if(!neighborColors.contains(color)) {
                    res[i-1] = color;
                    break;
                }
            }
        }
        return res;
    }

}
