package backtrack;

import java.util.Arrays;

public class _split_string_into_unique_primes_ {
    public static void main(String[] args) {
        System.out.println(splitPrimes("31173"));
    }
    public static int splitPrimes(String inputStr) {
        // WRITE YOUR BRILLIANT CODE HERE
        Arrays.fill(primes, true);
        initPrimes();
        return bc(0, inputStr);
    }

    static int bc(int start, String inputStr) {
        if(start == inputStr.length()) return 1;
        int res = 0;
        for(int len = 1; len <= 4 && start + len <= inputStr.length(); len++) {
            String str = inputStr.substring(start, start+len);
            if(Integer.valueOf(str) >= 1000 ||
                    (start + len < inputStr.length() && inputStr.charAt(start+len) == '0') ||
                    !primes[Integer.valueOf(str)]) {
                continue;
            }
            res += bc(start+len, inputStr);
        }
        return res;
    }

    static void initPrimes() {
        primes[0] = false;
        primes[1] = false;
        for(int i = 2; i <= 1000; i++) {
            if(primes[i]){
                for(int j = i*i; j <= 1000; j += i) primes[j] = false;
            }
        }
    }

    static boolean[] primes = new boolean[1001];
}
