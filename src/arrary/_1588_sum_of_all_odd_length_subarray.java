package arrary;

public class _1588_sum_of_all_odd_length_subarray {
    //running sum version
    //there is also O(n) solution which depends on math analysis, but I prefer this one
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if ((j - i + 1) % 2 == 1) { //if odd length
                    res += sum;
                }
            }
        }
        return res;
    }
}
