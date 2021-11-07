package backtrack;
import java.util.*;
public class _465_optimal_account_balancing {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 10}, {2,0,5}};
        new _465_optimal_account_balancing().minTransfers(arr);
    }
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> balances = new HashMap<>();
        for (int[] txn : transactions) {
            int from = txn[0];
            int to = txn[1];
            int amount = txn[2];
            balances.put(from, balances.getOrDefault(from, 0) - amount);
            balances.put(to, balances.getOrDefault(to, 0) + amount);
        }
        List<Integer> debts = new ArrayList<>(balances.values());
        return dfs(debts, 0);
    }

    private int dfs(List<Integer> debts, int start) {
        while (start < debts.size() && debts.get(start) == 0)
            start++;
        if (start == debts.size())
            return 0;
        int res = Integer.MAX_VALUE;
        for (int i = start + 1; i < debts.size(); i++) {
            if (debts.get(start) * debts.get(i) < 0) {
                debts.set(i, debts.get(i) + debts.get(start)); // assume debts[start] has been cleared
                res = Math.min(res, 1 + dfs(debts, start + 1));
                debts.set(i, debts.get(i) - debts.get(start)); // backtrack
            }
        }
        return res;
    }
}
