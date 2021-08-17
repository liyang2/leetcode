package graph;

import java.util.*;
// https://leetcode.com/problems/minimum-degree-of-a-connected-trio-in-a-graph/
public class _1761_shopping_patterns {
    public int minTrioDegree(int n, int[][] edges) {
        // keep track degree of each node
        Map<Integer, Integer> degrees = new HashMap<>();

        // easily know if there's an edge between any two nodes
        boolean[][] existsEdge = new boolean[n+1][n+1];

        for(int[] edge: edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            degrees.put(n1, degrees.getOrDefault(n1, 0)+1);
            degrees.put(n2, degrees.getOrDefault(n2, 0)+1);
            existsEdge[n1][n2] = true;
            existsEdge[n2][n1] = true;
        }

        int min = Integer.MAX_VALUE;
        for(int[] edge: edges) {
            for(int i = 1; i <=n; i++) {
                if(existsEdge[i][edge[0]] && existsEdge[i][edge[1]]) {
                    int d = degrees.get(i) + degrees.get(edge[0]) + degrees.get(edge[1]) - 6;
                    min = Math.min(min, d);
                }
            }
        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }

}
