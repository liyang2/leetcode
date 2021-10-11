package bit;

public class _201_bitwise_and_of_numbers_range {
    public int rangeBitwiseAnd(int m, int n) {
        int shifts = 0;
        while(m != n) {
            m >>= 1;
            n >>= 1;
            shifts++;
        }
        return m << shifts;
    }
}
