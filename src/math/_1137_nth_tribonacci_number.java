package math;

public class _1137_nth_tribonacci_number {
    public int tribonacci(int n) {
        int zero = 0;
        int first = 1;
        int second = 1;
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;

        for(int i = 3; i <= n; i++) {
            int third = zero + first + second;
            zero = first;
            first = second;
            second = third;
        }
        return second;
    }
}
