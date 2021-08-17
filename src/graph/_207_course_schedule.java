package graph;

import java.util.*;

public class _207_course_schedule {
    // dfs with backtrack
    public boolean canFinish(int num, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        List<Integer>[] adjList = new ArrayList[num];
        for(int i = 0; i < num; i++) {
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge : prerequisites) {
            adjList[edge[0]].add(edge[1]);
        }

        boolean[] path = new boolean[num];
        boolean[] visited = new boolean[num];

        for(int i = 0; i < num; i++) {
            if(hasCycle(i, adjList, path, visited)) {
                return false;
            }
        }
        return true;
    }

    boolean hasCycle(int root, List<Integer>[] adjList, boolean[] path, boolean[] visited) {
        if(path[root]) return true;
        if(visited[root]) return false;

        path[root] = true;
        visited[root] = true;

        for(int neighbor : adjList[root]) {
            if(hasCycle(neighbor, adjList, path, visited))
                return true;
        }

        path[root] = false; // backtrack
        return false;
    }
}
