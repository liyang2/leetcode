package memoization;

import java.util.*;

// can also be solved using bitmask,
// see https://leetcode.com/problems/minimum-number-of-work-sessions-to-finish-the-tasks/discuss/1432155/Easier-than-top-voted-ones-or-LegitClickbait-or-c%2B%2B
public class _1986_min_number_work_sessions_finish_tasks {
    List<Integer> sessions;
    int[] tasks;
    int sessionTime;
    Map<String, Integer> memo;

    public int minSessions(int[] tasks, int sessionTime) {
        sessions = new ArrayList<>();
        this.tasks = tasks;
        this.sessionTime = sessionTime;
        this.memo = new HashMap<>();

        return solve(0);
    }

    // return min number of sessions to finish tasks[pos:]
    int solve(int pos) {
        if(pos == tasks.length) return 0;
        String key = encodeState( pos);
        if(memo.containsKey(key)) return memo.get(key);

        // use a single session solely for current task
        sessions.add(tasks[pos]);
        int res = 1+solve(pos+1);
        sessions.remove(sessions.size()-1);

        // try add current task to previous session
        for(int i = 0; i < sessions.size(); i++) {
            if(sessions.get(i) + tasks[pos] <= sessionTime) {
                sessions.set(i, sessions.get(i) + tasks[pos]);
                res = Math.min(res, solve(pos+1));
                sessions.set(i, sessions.get(i) - tasks[pos]);
            }
        }
        memo.put(key, res);
        return res;
    }

    String encodeState(int pos) {
        List<Integer> copy = new ArrayList<>(sessions);
        Collections.sort(copy);
        StringBuilder sb = new StringBuilder();
        sb.append(pos + "$");
        for(int t : copy) {
            sb.append(t + "$");
        }
        return sb.toString();
    }
}
