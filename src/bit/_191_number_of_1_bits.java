package bit;

public class _191_number_of_1_bits {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count += (n & 1);
            n =n >>> 1;
        }
        return count;
    }
}
