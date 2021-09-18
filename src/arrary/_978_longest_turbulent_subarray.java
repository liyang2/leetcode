package arrary;

public class _978_longest_turbulent_subarray {
    public int maxTurbulenceSize(int[] arr) {
        int prev = -2; // some random value other than -1, 0, 1
        int len = 1;
        int res = 1;
        for(int i = 1; i < arr.length; i++) {
            int cur = Integer.compare(arr[i-1], arr[i]);
            if(cur == 0) {
                len = 1;
            } else if(cur == prev){
                len = 2;
            } else {
                len++;
            }
            res = Math.max(res, len);
            prev = cur;
        }
        return res;
    }
}
