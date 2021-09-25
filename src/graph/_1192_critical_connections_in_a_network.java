package graph;
import java.util.*;
public class _1192_critical_connections_in_a_network {
    ///https://www.youtube.com/watch?v=mKUsbABiwBI
    Map<Integer, List<Integer>> adjs;
    int[] minSeen;
    List<List<Integer>> res;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        adjs = new HashMap<>();
        minSeen = new int[n];
        Arrays.fill(minSeen, -1);
        res = new ArrayList<>();

        for(List<Integer> edge: connections) {
            adjs.computeIfAbsent(edge.get(0), e-> new ArrayList<>()).add(edge.get(1));
            adjs.computeIfAbsent(edge.get(1), e-> new ArrayList<>()).add(edge.get(0));
        }

        dfs(0, -1, 0);
        return res;
    }

    // lvl is the distance from current node to node 0
    int dfs(int node, int parent, int lvl) {
        minSeen[node] = lvl;

        for(int child : adjs.get(node)) {
            if(child == parent)
                continue;
            else if(minSeen[child] == -1) {
                minSeen[node] = Math.min(minSeen[node], dfs(child, node, lvl+1));
            } else {
                minSeen[node] = Math.min(minSeen[node], minSeen[child]);
            }
        }
        if(minSeen[node] == lvl && parent != -1) {
            res.add(Arrays.asList(parent, node));
        }
        return minSeen[node];
    }
}
