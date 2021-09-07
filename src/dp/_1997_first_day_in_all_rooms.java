package dp;

//https://leetcode.com/problems/first-day-where-you-have-been-in-all-the-rooms/discuss/1445225/Python-short-dp-explained
// fuck the mod, BTW

public class _1997_first_day_in_all_rooms {
    public int firstDayBeenInAllRooms(int[] A) {
        int mod = 1000000007;
        int n = A.length;
        int[] dp = new int[n]; // dp[0]=0, it takes 0 days to visit room 0

        for(int i = 1; i < n; i++) {
            dp[i] = ((dp[i-1]+mod-dp[A[i-1]])%mod+dp[i-1]+2)%mod;
        }
        return dp[n-1];
    }
}
