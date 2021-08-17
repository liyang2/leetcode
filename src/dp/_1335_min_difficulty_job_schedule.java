package dp;

import java.util.*;

public class _1335_min_difficulty_job_schedule {
    public static void main(String[] args) {
        int x = new _1335_min_difficulty_job_schedule().minDifficulty(new int[]{1,1,1,}, 3);
        System.out.println(x);
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        int N = jobDifficulty.length;
        if(N < d) return -1;
        int[][] dp = new int[N][d+1]; // stores return value of each dfs()
        for(int[] arr : dp) {
            Arrays.fill(arr, -1); //-1 means uncalculated
        }
        return dfs(0, d, jobDifficulty, dp);
    }

    // dfs() never returns -1,
    // for invalid cases -1 will be replace by Integer.MAX_VALUE
    int dfs(int start, int d, int[] jobs, int[][] dp) {
        if(d == 0 && start == jobs.length) return 0;
        if(d == 0 || start == jobs.length) return Integer.MAX_VALUE;
        if(dp[start][d] != -1) return dp[start][d];

        int curDayMax = jobs[start];
        int min = Integer.MAX_VALUE;
        for(int i = start; i < jobs.length; i++) {
            curDayMax = Math.max(curDayMax, jobs[i]);
            int right = dfs(i+1, d-1, jobs, dp);
            if(right != Integer.MAX_VALUE) {
                min = Math.min(min, curDayMax + right);
            }
        }
        dp[start][d] = min;
        return dp[start][d];
    }

}
