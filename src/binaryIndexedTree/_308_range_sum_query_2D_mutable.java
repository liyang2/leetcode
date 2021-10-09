package binaryIndexedTree;

public class _308_range_sum_query_2D_mutable {
}
class NumMatrix {

    int m,n;
    int[][] bit;

    // lowest bit
    private int lsb(int n) {return n & -n;}

    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        bit = new int[m+1][n+1];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int old_val = sumRegion(row, col, row, col);
        row++; col++;
        int diff = val - old_val;

        for(int i = row; i <= m; i+=lsb(i)) {
            for(int j = col; j <= n; j+=lsb(j)) {
                bit[i][j] += diff;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        return query(row2, col2) - query(row2, col1-1) - query(row1-1, col2)
                + query(row1-1, col1-1);
    }

    //1 based
    private int query(int r, int c) {
        int sum = 0;
        for (int i = r; i > 0; i -= lsb(i)) {
            for (int j = c; j > 0; j -= lsb(j)) {
                sum += this.bit[i][j];
            }
        }
        return sum;
    }
}