package graph;
import java.util.*;
public class _detect_cycles_in_directed_graph {
    ArrayList<ArrayList<Integer>> adj;
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        this.adj = adj;

        // code here
        for(int i = 0; i < V; i++) {
            if(hasCycle(i, new HashSet<>())) {
                return true;
            }
        }
        return false;
    }
    Set<Integer> noCycles = new HashSet<>();

    boolean hasCycle(int i, Set<Integer> path) {
        if(noCycles.contains(i)) return false;
        path.add(i);
        for(int neighbor: adj.get(i)) {
            if(path.contains(neighbor)) return true;
            if(hasCycle(neighbor, path)) {
                return true;
            }
        }
        path.remove(i);
        noCycles.add(i);
        return false;
    }
}
