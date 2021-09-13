package binaryTree;

import pojos.TreeNode;

public class _270_cloest_binary_search_tree {
    int res = 0;
    double minDiff = Integer.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        recur(root, target);
        return res;
    }

    void recur(TreeNode node, double target) {
        if(node == null) return;
        double diff = Math.abs(node.val - target);
        if(diff < minDiff) {
            minDiff = diff;
            res = node.val;
        }
        if(node.val == target) return;
        else if(node.val < target) {
            recur(node.right, target);
        } else {
            recur(node.left, target);
        }
    }
}
