package grid;
import java.util.*;
public class _85_maximal_rectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        int res = 0;
        int[] dp = new int[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '0') {
                    dp[j] = 0;
                } else {
                    dp[j] += 1;
                }
            }
            res = Math.max(res, largestRectangleArea(dp));
        }
        return res;
    }

    // copied from lc84
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i <= heights.length; i++) {
            int heightAtI = i == heights.length ? -1 : heights[i];
            while(!stk.isEmpty() && heightAtI < heights[stk.peek()]) {
                int height = heights[stk.pop()];
                int left = stk.isEmpty() ? -1 : stk.peek(); // if stk.isEmpty(), it means bars on the left all taller and has been popped
                int right = i;
                res = Math.max(res, (right - left - 1) * height);
            }
            stk.push(i);
        }
        return res;
    }
}
