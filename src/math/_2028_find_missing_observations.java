package math;

// don't need DP because after we know K, the choices are consecutive:
// 1, 2, 3, 4,5, 6
public class _2028_find_missing_observations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sumM = 0;
        for(int i = 0; i < rolls.length; i++) {
            sumM += rolls[i];
        }
        int K = (m + n) * mean - sumM;
        // now it reduces to find a combination of n number ranging from [1, 6] to sum up to K
        if(K < n || K > n * 6) {
            return new int[0];
        }

        int[] arr = new int[n];
        int p = K / n;
        int q = K % n;
        for(int i = 0; i < n; i++) {
            arr[i] = p;
            if(q > 0) {
                arr[i] += 1;
                q--;
            }
        }
        return arr;
    }

}
