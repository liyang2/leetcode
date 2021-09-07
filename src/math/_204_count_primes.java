package math;

import java.util.Arrays;

public class _204_count_primes {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for(int i = 2; i <= (int)Math.sqrt(n); i++) {
            for(int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++) {
            count += isPrime[i] ? 1 : 0;
        }
        return count;
    }
}
