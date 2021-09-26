package math;
import java.util.*;

// when it comes to "factor", think of Math.sqrt()
public class _1492_kth_factor_of_n {
    public int kthFactor(int n, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                q.add(i);
                if(n != i * i)
                    q.add(n/i);
            }
            while(q.size() > k)
                q.poll();
        }
        return q.size() < k ? -1 : q.peek();
    }

}
