package dp;

public class _1335_min_difficult_jobs_schedule_draft {

    int[][] dp;

    public int minDifficulty(int[] jobDifficulty, int d) {
        dp = new int[jobDifficulty.length][d+1];
        int res =  dfs(0, jobDifficulty, d);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    int dfs(int index, int[] jobs, int d) {
        int jobsLeft = jobs.length - index;
        if(d == 0 && jobsLeft == 0) return 0; //corner case
        if(d == 0 || jobsLeft == 0) return Integer.MAX_VALUE;
        if(dp[index][d] != 0) return dp[index][d];

        int curDayMax = 0;
        int min = Integer.MAX_VALUE;
        for(int i = index; i < jobs.length; i++) {
            curDayMax = Math.max(curDayMax, jobs[i]);
            int rest = dfs(i+1, jobs, d-1);
            if(rest != Integer.MAX_VALUE) {
                min = Math.min(min, curDayMax + rest);
            }
        }
        dp[index][d] = min;
        return min;
    }
}
