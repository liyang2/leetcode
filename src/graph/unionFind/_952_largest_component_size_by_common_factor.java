package graph.unionFind;
import java.util.*;
public class _952_largest_component_size_by_common_factor {
    public static void main(String[] args) {
        new _952_largest_component_size_by_common_factor().
                largestComponentSize(new int[]{99,100,69,39,14,56,91,60});
    }
    int[] parent;
    int[] rank;

    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        parent = new int[n];
        rank = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>(); // rootEle -> count

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int num1 = nums[i];
                int num2 = nums[j];

                if (gcd(num1, num2) != 1) {
                    union(i, j);
                    int root = find(i);
                    map.putIfAbsent(root, new HashSet<>());
                    map.get(root).add(i);
                    map.get(root).add(j);
                }
            }
        }
        int res = 0;
        for (Set<Integer> set : map.values()) {
            res = Math.max(res, set.size());
        }
        return res;
    }

    private int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else {
                parent[rootJ] = rootI;
                rank[rootI]++;
            }
        }
    }

    private int gcd(int i, int j) {
        if (i == 0) {
            return j;
        }
        return gcd(j % i, i);
    }
}
