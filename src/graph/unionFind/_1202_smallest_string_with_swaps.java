package graph.unionFind;

import java.util.*;

public class _1202_smallest_string_with_swaps {
    int[] parent;
    int[] rank;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (List<Integer> pair: pairs) {
            union(pair.get(0), pair.get(1));
        }
        // rootIndex -> sorted chars
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int rootIndex = find(i);
            map.putIfAbsent(rootIndex, new PriorityQueue<>());
            map.get(rootIndex).add(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            arr[i] = map.get(find(i)).poll();
        }
        return new String(arr);
    }

    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else {
                parent[rootI] = rootJ;
                rank[rootJ]++;
            }
        }
    }

    private int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
}
