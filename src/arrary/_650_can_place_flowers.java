package arrary;

public class _650_can_place_flowers {
    public boolean canPlaceFlowers(int[] A, int n) {
        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0) {
                if((i == 0 || A[i-1] == 0) && (i == A.length-1 || A[i+1] ==0)) {
                    A[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }
}
