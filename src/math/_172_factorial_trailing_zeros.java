package math;

public class _172_factorial_trailing_zeros {
    public int trailingZeroes(int n) {
        // how many 5s in each number [1, n]
        int count = 0;
        for(int i = 1; i <= n; i++) {
            int d = i;
            while(d % 5 == 0) {
                count++;
                d /= 5;
            }
        }
        return count;
    }
}
