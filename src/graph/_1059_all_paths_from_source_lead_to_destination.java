package graph;

import java.util.*;

public class _1059_all_paths_from_source_lead_to_destination {
    public static void main(String[] args) {
        new _1059_all_paths_from_source_lead_to_destination().
                leadsToDestination(3, new int[][]{{0,1}, {0,2}}, 0, 2);
    }
    enum State {WHITE, GREY, BLACK};
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        State[] states = new State[n];
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
        }
        return leadsToDestHelper(source, destination, states, adjList);
    }

    private boolean leadsToDestHelper(int cur, int dest, State[] states, List<Integer>[] adjList){
        if (states[cur] == State.GREY) {
            return false;
        } else if (states[cur] == State.BLACK) {
            return true;
        }
        if (adjList[cur].isEmpty()) {
            return cur == dest;
        }
        states[cur] = State.GREY;
        for (int next : adjList[cur]) {
            if (!leadsToDestHelper(next, dest, states, adjList)) {
                return false;
            }
        }
        states[cur] = State.BLACK;
        return true;
    }
}


