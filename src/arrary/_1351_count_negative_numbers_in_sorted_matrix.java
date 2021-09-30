package arrary;

public class _1351_count_negative_numbers_in_sorted_matrix {
    public int countNegatives(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int i = m - 1, j = 0;

        while(i >= 0 && j < n) {
            if(grid[i][j] >= 0) {
                j++;
            } else {
                res += n - j;
                i--;
            }
        }
        return res;
    }
}
