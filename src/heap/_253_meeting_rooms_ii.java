package heap;

import java.util.*;

public class _253_meeting_rooms_ii {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        int res = 1;
        q.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] earliestFinish = q.peek();
            if(cur[0] >= earliestFinish[1]) {
                q.poll();
                q.add(cur);
            } else {
                res++;
                q.add(cur);
            }
        }
        return res;
    }
}
