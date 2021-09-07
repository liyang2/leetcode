package bit;

public class _190_reverse_bits {
    public static void main(String[] args) {
        int d = 1 << 1;
        System.out.println(d);
    }

    public int reverseBits(int n) {
        int x = 0;
        for(int i = 0; i < 32; i++) {
            x = (x << 1) | (n & 1);
            n = n >> 1;
        }
        return x;
    }
}
