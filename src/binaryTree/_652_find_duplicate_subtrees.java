package binaryTree;
import pojos.TreeNode;

import java.util.*;

// because of string concatenation, time complexity is O(n^2)
// see the follow-up version of O(n)
public class _652_find_duplicate_subtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        postOrder(root, map, res);
        return res;
    }

    String postOrder(TreeNode node, Map<String, Integer> map, List<TreeNode> res) {
        if (node == null)
            return "#";
        String nodeStr = node.val + "," + postOrder(node.left, map, res) + ","
                + postOrder(node.right, map, res);
        if (map.getOrDefault(nodeStr, 0) == 1) {
            res.add(node);
        }
        map.put(nodeStr, map.getOrDefault(nodeStr, 0) + 1);
        return nodeStr;
    }
}
