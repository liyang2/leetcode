package math;

public class _829_consecutive_numbers_sum {
    // N = k * i + (i - 1) * i / 2 => N - (i - 1) * i / 2 = k * i
    // k > 0
    public int consecutiveNumbersSum(int n) {
        int res = 0;
        for(int i = 1; (i-1) * i /2 < n; i++) {
            if((n - (i-1) * i/2) % i == 0)
                res ++;
        }
        return res;
    }
}
