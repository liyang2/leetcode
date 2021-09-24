package graph;

import java.util.Arrays;

public class _547_number_of_provinces_UnionFind {
    class Solution {
        int[] parent;
        int[][] grid;
        public int findCircleNum(int[][] grid) {
            int n = grid.length;
            this.grid = grid;
            parent= new int[n];
            Arrays.fill(parent, -1);
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == 1 && i != j)
                        union(i, j);
                }
            }

            int res = 0;
            for(int i = 0; i < n; i++) {
                if(parent[i] == -1)
                    res++;
            }
            return res;
        }

        void union(int i, int j) {
            int parentI = find(i);
            int parentJ = find(j);
            if(parentI != parentJ) {
                parent[parentI] = parentJ;
            }
        }

        int find(int i) {
            if(parent[i] == -1) {
                return i;
            } else {
                parent[i] = find(parent[i]);
                return parent[i];
            }
        }
    }
}
