package graph;
import java.util.*;

class _261_graph_valid_tree {

    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0;i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> seen = new HashSet<>();
        if(findCircle(0, -1, adjList, seen)) return false;
        return seen.size() == n; // in case of forest, forest is not tree
    }

    // introduce 'parent' to make sure we don't go back
    // then seen can be used purely for detecting circles
    boolean findCircle(int root, int parent, List<List<Integer>> adjList, Set<Integer> seen) {
        if(seen.contains(root)) {
            return true;
        }
        seen.add(root);

        for(int neighbor : adjList.get(root)) {
            if(neighbor != parent) {
                if(findCircle(neighbor, root, adjList, seen)) {
                    return true;
                }
            }
        }
        return false;
    }
}
