package monoStack;
import java.util.*;
public class _1475_final_prices_with_special_discount {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = Arrays.copyOf(prices, n);

        Stack<Integer> stack = new Stack<>(); // mono stack
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                ans[idx] -= prices[i];
            }
            stack.push(i);
        }
        return ans;
    }
}
