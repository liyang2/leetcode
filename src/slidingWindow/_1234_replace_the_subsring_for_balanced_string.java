package slidingWindow;

// needs a little thinking to picture the window sliding through
public class _1234_replace_the_subsring_for_balanced_string {
    public int balancedString(String s) {
        // keep count of occurences of chars outside the window
        int[] arr = new int[128];
        int n = s.length();
        int res = n+1;
        int k = n/4;
        int l = 0, r= 0;
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }
        if(arr['Q'] == k && arr['W'] ==k && arr['E'] == k && arr['R'] == k)
            return 0;


        for(r = 0; r < s.length(); r++) {
            // erase the character inside the window, so that "arr" actually counts only outside
            arr[s.charAt(r)]--;
            while(l <= n && arr['Q'] <= k && arr['W'] <=k && arr['E'] <= k && arr['R'] <= k) {
                res = Math.min(res, r - l + 1);
                arr[s.charAt(l++)]++;
            }
        }
        return res;
    }
}
