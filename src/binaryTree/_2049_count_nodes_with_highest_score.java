package binaryTree;

import java.util.*;

public class _2049_count_nodes_with_highest_score {
    // This is a graph problem instead of a tree problem
    // because you don't know which one is left child, or right child
    // but we know each node at most has two children

    long maxScore = 0;
    int maxScoreCount = 0;
    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        List<Integer>[] adjs = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjs[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            adjs[parents[i]].add(i);
        }

        dfs(0, adjs);
        return maxScoreCount;
    }

    // return size of each subtree
    long dfs(int node, List<Integer>[] adjs) {
        int n = adjs.length;
        long leftSize = 0;
        if (adjs[node].size() >= 1) {
            leftSize = dfs(adjs[node].get(0), adjs);
        }
        long rightSize = 0;
        if (adjs[node].size() >= 2) {
            rightSize = dfs(adjs[node].get(1), adjs);
        }
        long score = minOne(leftSize) * minOne(rightSize) * minOne(n - 1 - leftSize - rightSize);
        if (score > maxScore) {
            maxScore = score;
            maxScoreCount = 1;
        } else if (score == maxScore) {
            maxScoreCount++;
        }
        return leftSize + rightSize + 1;
    }

    long minOne(long num) {
        return num == 0 ? 1 : num;
    }
}
