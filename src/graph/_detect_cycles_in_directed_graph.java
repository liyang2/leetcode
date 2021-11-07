package graph;
import java.util.*;
public class _detect_cycles_in_directed_graph {
    enum State { WHITE, GREY, BLACK}
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        State[] states = new State[n];
        Arrays.fill(states, State.WHITE);
        for (int i = 0; i < n; i++) {
            if (isCyclicHelper(i, adj, states)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCyclicHelper(int node, ArrayList<ArrayList<Integer>> adj, State[] states) {
        if (states[node] == State.GREY) {
            return true;
        } else if (states[node] == State.BLACK) {
            return false;
        }
        states[node] = State.GREY;
        for (int next : adj.get(node)) {
            if (isCyclicHelper(next, adj, states)) {
                return true;
            }
        }
        states[node] = State.BLACK;
        return false;
    }
}

