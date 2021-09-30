package arrary;

import java.util.Arrays;

public class _221_maximal_square {
    int[][] cache;
    public int maximalSquare(char[][] matrix) {
        int res  = 0;
        cache = new int[matrix.length][matrix[0].length];
        for(int[] arr: cache)
            Arrays.fill(arr, -1);

        for(int i  = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                int len = recur(matrix, i, j);
                res = Math.max(res, len * len);
            }
        }
        return res;
    }

    int recur(char[][] matrix, int i, int j) {
        if(i == matrix.length ||j == matrix[0].length || matrix[i][j] == '0')
            return 0;
        if(cache[i][j] != -1)
            return cache[i][j];

        int len = 1+Math.min(recur(matrix, i+1, j),
                Math.min(recur(matrix, i, j+1), recur(matrix, i+1,j+1)));

        cache[i][j] = len;
        return len;
    }
}
