package binaryTree;
import java.util.*;
import pojos.TreeNode;

public class _652_find_duplicate_subtrees_followup {
    int id = 0;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, String> nodeToId = new HashMap<>();
        postOrder(root, countMap, nodeToId, res);
        return res;
    }

    String postOrder(TreeNode node, Map<String, Integer> countMap,
                     Map<String, String> nodeToId, List<TreeNode> res) {
        if (node == null)
            return "#";
        String left = postOrder(node.left, countMap, nodeToId, res);
        String right = postOrder(node.right, countMap, nodeToId, res);
        String nodeStr = node.val + "," + left + "," + right;

        if (countMap.getOrDefault(nodeStr, 0) == 1) {
            res.add(node);
        }
        countMap.put(nodeStr, countMap.getOrDefault(nodeStr, 0) + 1);

        if (!nodeToId.containsKey(nodeStr)) {
            nodeToId.put(nodeStr, "" + id++);
        }
        return nodeToId.get(nodeStr);
    }
}
