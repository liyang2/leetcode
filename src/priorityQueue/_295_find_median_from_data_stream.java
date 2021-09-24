package priorityQueue;
import java.util.*;
public class _295_find_median_from_data_stream {
    PriorityQueue<Integer> lo; //max heap
    PriorityQueue<Integer> hi; // min heap

    /** initialize your data structure here. */
    public _295_find_median_from_data_stream() {
        lo = new PriorityQueue<Integer>(Collections.reverseOrder());
        hi = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        lo.add(num);
        hi.add(lo.poll());
        if(hi.size() > lo.size()) {
            lo.add(hi.poll());
        }
    }

    public double findMedian() {
        int count = lo.size() + hi.size();
        if(count % 2 == 1) {
            return lo.peek();
        } else {
            return (lo.peek() + hi.peek()) / 2.0;
        }
    }
}
