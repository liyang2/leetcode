package binarySearch;

// https://www.youtube.com/watch?v=79vyrSH7VO8
public class _1901_find_peak_element_ii {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int startRow = 0;
        int endRow = m - 1;
        while (startRow + 1 < endRow) { // so that midRow+1/-1 is always valid
            int midRow = startRow + (endRow - startRow) / 2;
            int j = findMaxElementIndex(mat[midRow]);
            if (mat[midRow][j] > mat[midRow - 1][j]) {
                if (mat[midRow][j] > mat[midRow + 1][j]) {
                    return new int[] {midRow, j};
                } else {
                    startRow = midRow + 1;
                }
            } else {
                endRow = midRow - 1;
            }
        }
        int[] candidates = {startRow, endRow};
        for (int candidateRow : candidates) {
            int j = findMaxElementIndex(mat[candidateRow]);
            if ((candidateRow == 0     || mat[candidateRow][j] > mat[candidateRow - 1][j]) &&
                    (candidateRow == m - 1 || mat[candidateRow][j] > mat[candidateRow + 1][j])) {
                return new int[] {candidateRow, j};
            }
        }

        return null;
    }

    private int findMaxElementIndex(int[] arr) {
        int maxEle = -1;
        int maxEleIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxEle) {
                maxEle = arr[i];
                maxEleIndex = i;
            }
        }
        return maxEleIndex;
    }
}
