package graph;

import java.util.Arrays;

public class _1101_earliest_moment_everyone_become_friends {
    int[] parent;
    int[] rank;
    public int earliestAcq(int[][] logs, int n) {
        parent = new int[n];
        rank = new int[n];
        int components = n;
        Arrays.sort(logs, (o1, o2)-> o1[0] - o2[0]);

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int[] log : logs) {
            int time = log[0];
            if (union(log[1], log[2])) {
                if (--components == 1) {
                    return time;
                }
            }
        }
        return -1;
    }

    private boolean union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI == rootJ) {
            return false;
        } else {
            if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else {
                parent[rootJ] = rootI;
                rank[rootI]++;
            }
            return true;
        }
    }
    private int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
}
