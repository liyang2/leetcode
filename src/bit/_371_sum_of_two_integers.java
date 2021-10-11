package bit;

public class _371_sum_of_two_integers {
    public int getSum(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        while(b != 0) {
            int carry = (a & b) << 1;
            int res = a ^ b;
            a = res;
            b = carry;
        }
        return a;
    }
}
