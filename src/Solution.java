import java.util.*;

class Solution {
    List<int[]> jobs;
    int[][] memo;
    // memo[i][0]: skipping ith job,
    // memo[i][1]: schedule ith job

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        jobs = new ArrayList<>();
        memo = new int[startTime.length][2];
        for(int i = 0; i < memo.length; i++)
            Arrays.fill(memo[i], -1);

        for(int i = 0; i < startTime.length; i++) {
            jobs.add(new int[]{startTime[i], endTime[i], profit[i]});
        }
        jobs.sort((o1, o2) -> o1[0] - o2[0]);

        return jobSchedulingHelper(0, 0);
    }

    int jobSchedulingHelper(int time, int idx) {
        if(idx == jobs.size()) return 0;

        int res = 0;
        if(memo[idx][0] != -1) {
            res = memo[idx][0];
        } else {
            res = jobSchedulingHelper(time, idx+1);
            memo[idx][0] = res;
        }

        int res2= 0;
        if(memo[idx][1] != -1) {
            res2 = memo[idx][1];
        } else {
            res2 = jobs.get(idx)[2] + jobSchedulingHelper(jobs.get(idx)[1], idx+1);
            memo[idx][1] = res2;
        }

        if(jobs.get(idx)[0] >= time) {
            return Math.max(res, res2);
        } else
            return res;
    }
}