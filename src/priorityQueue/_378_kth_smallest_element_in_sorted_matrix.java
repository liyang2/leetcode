package priorityQueue;

import java.util.PriorityQueue;

public class _378_kth_smallest_element_in_sorted_matrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        // (i, j, matrix[i][j])
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->a[2]-b[2]);
        // add first row to q
        for(int j = 0; j < n; j++) {
            q.add(new int[]{0, j, matrix[0][j]});
        }
        int x = k-1;
        while(x-- > 0) {
            int[] tuple = q.poll();
            int i = tuple[0], j = tuple[1];
            if(i+1 < n)
                q.add(new int[]{i+1, j, matrix[i+1][j]});
        }
        return q.poll()[2];
    }
}
