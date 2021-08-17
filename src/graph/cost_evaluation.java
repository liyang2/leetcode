package graph;

import java.util.ArrayList;
import java.util.List;

//https://aonecode.com/oa-cloudfront-caching
public class cost_evaluation {
    public int costEvaluation(int n, int[][] connections) {
        boolean[] visited = new boolean[n];
        List<Integer>[] adjList = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge: connections) {
            int n1 = edge[0];
            int n2 = edge[1];
            adjList[n1].add(n2);
            adjList[n2].add(n1);
        }
        List<Integer> components = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                int size = dfs(i, visited, adjList);
                components.add(size);
            }
        }
        int res = 0;
        for(int comp : components) {
            res += Math.ceil(Math.sqrt(comp));
        }
        return res;
    }

    int dfs(int i, boolean[] visited, List<Integer>[] adjList) {
        visited[i] = true;
        List<Integer> neighbors = adjList[i];
        int res = 1;
        for(int neighbor : neighbors) {
            if(!visited[neighbor]) {
                res += dfs(neighbor, visited, adjList);
            }
        }
        return res;
    }
}
