package prefixSum;
import pojos.TreeNode;

import java.util.*;
public class _437_path_sum_iii {
    int target;
    Map<Integer, Integer> map = new HashMap<>();
    int res = 0;

    public int pathSum(TreeNode root, int target) {
        this.target= target;
        recur(root, 0);
        return res;
    }

    void recur(TreeNode node, int curSum) {
        if(node == null) return;
        curSum += node.val;
        if(curSum == target) {
            res++;
        }
        if(map.containsKey(curSum - target)) {
            res += map.get(curSum - target);
        }
        map.put(curSum, map.getOrDefault(curSum, 0)+1);
        recur(node.left, curSum);
        recur(node.right, curSum);
        map.put(curSum, map.get(curSum)-1);
    }
}
