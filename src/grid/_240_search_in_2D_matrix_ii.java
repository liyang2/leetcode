package grid;

public class _240_search_in_2D_matrix_ii {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m-1, j = 0;
        while(i >= 0 && j < n) {
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
