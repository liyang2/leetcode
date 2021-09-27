package priorityQueue;
import java.util.*;
public class _1648_sell_diminishing_valued_colored_balls {

    public static void main(String[] args) {
        new _1648_sell_diminishing_valued_colored_balls().maxProfit(
                new int[]{3,5}, 6
        );
    }
    static final int MOD = 1000000007;
    public int maxProfit(int[] inventory, int orders) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        long res = 0;
        for(int x : inventory)
            q.add(x);
        while(orders > 0 && !q.isEmpty()) {
            if(q.size()== 1) {
                res += compute(q.peek(), orders);
                break;
            }
            int v = q.poll();
            int diff = v - q.peek();
            diff = Math.min(diff, orders-1);
            res += (2L * v - diff) * (diff+1) / 2;
            v -= diff+1;
            if(v > 0)
                q.add(v);
            orders-=diff+1;
        }
        return (int)(res % MOD);
    }

    long compute(int n, int orders) {
        if(n > orders) {
            return (2L * n - orders + 1) * orders / 2;
        } else {
            return ((long)n+1)*n/2;
        }
    }
}
