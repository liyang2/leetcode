package math;


import java.util.Comparator;
import java.util.stream.IntStream;
// f**king hate this problem
public class _1648_sell_diminishing_valued_colored_balls {
    public static void main(String[] args) {
        System.out.println(new _1648_sell_diminishing_valued_colored_balls()
                .maxProfit(new int[]{5, 2}, 4));
    }

    int MOD = 1000000007;
    public int maxProfit(int[] inventory, int orders) {
        int[] arr = IntStream.of(inventory)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .toArray();

        int n = inventory.length;
        int cur = arr[0]; // current highest price
        int c = 0;
        long res = 0;
        while(orders > 0) {
            while(c < n && arr[c] == cur) ++c;
            int next = c == n ? 0 : arr[c];
            int sold = (cur - next) * c;

            if(orders >= sold) {
                res += (long)(cur + next + 1) * (cur - next) / 2 * c;
                orders -= sold;
                cur = next;
            } else {
                int rows = orders / c;
                int left = orders % c;
                int next_p = cur - rows;
                res +=  (long)(cur + next_p + 1) * rows/ 2 * c + (long)left * next_p;
                break;
            }
            res %= MOD;
        }
        return (int)(res % MOD );
    }
}
