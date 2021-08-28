package memoization;

import java.util.*;

public class _1235_max_profit_job_schedule {
    List<int[]> jobs;
    int[][] memo;
    // stores max profit given there's enough time to schedule ith item
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
        jobs.sort(Comparator.comparingInt(o -> o[0]));

        int d = jobSchedulingHelper(0, 0);
        return d;
    }

    int jobSchedulingHelper(int time, int idx) {
        if(idx == jobs.size()) return 0;
        if(time > jobs.get(idx)[0]) return jobSchedulingHelper(time, idx+1);

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

    public static void main(String[] args) {
        int[] start = {1, 2, 3, 4, 6};
        int[] end = {3,5,10,6,9};
        int[] profit = {20, 20, 100, 70, 60};
        new _1235_max_profit_job_schedule().jobScheduling(start, end, profit);
    }
}
