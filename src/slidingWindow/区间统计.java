package slidingWindow;

// lintcode 1667
public class 区间统计 {
    public long intervalStatistics(int[] arr, int k) {
        // Write your code here.
        int n = arr.length;
        long res = 0;
        int ones = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (arr[right] == 1) {
                ones++;
                continue;
            }
            if (arr[left] == 1) {
                ones--;
                left++;
            }
            while (ones > k) {
                if (arr[left++] == 1) {
                    ones--;
                }
            }
            res += right - left + 1 - ones; //终点是right的区间数量
        }
        return res;
    }
}
