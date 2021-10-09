package math;

public class gcd {

    int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        System.out.println(new gcd().gcd(3, 1));
    }
}
