package priorityQueue;
import java.util.*;

// what matters is endDay, we want to take the event which expires soonest
public class _1353_max_number_of_events_can_be_attended {

    //https://www.youtube.com/watch?v=ABH9cRhwmlg
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (o1, o2)-> Integer.compare(o1[1], o2[1]));
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i = 1; i <= 100000; i++)
            treeSet.add(i);

        int res = 0;
        for(int[] event: events) { // events are sorted by endDay
            Integer lowerBound = treeSet.ceiling(event[0]);
            if(lowerBound != null && lowerBound <= event[1]) {
                res++;
                treeSet.remove(lowerBound);
            }
        }
        return res;
    }

    // this one is faster but less easy to understand
    //https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/discuss/510263/JavaC%2B%2BPython-Priority-Queue
    public int maxEvents2(int[][] events) {
        Arrays.sort(events, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int i = 0;
        int n = events.length;
        int res = 0;
        for(int d = 1; d <= 100000; d++) {
            // add events which is joinable
            while(i < n && events[i][0] <= d) {
                q.add(events[i++][1]);
            }
            // get rid of expired events
            while(!q.isEmpty() && q.peek() < d) {
                q.poll();
            }
            if(!q.isEmpty()) {
                q.poll(); // join the event which expires soonest
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] events = {{1,4}, {4,4}, {2,2}, {3,4}, {1,1}};
        new _1353_max_number_of_events_can_be_attended()
                .maxEvents(events);
    }
}
