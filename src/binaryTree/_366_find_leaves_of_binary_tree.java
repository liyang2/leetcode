package binaryTree;
import pojos.TreeNode;

import java.util.*;
public class _366_find_leaves_of_binary_tree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        TreeNode dummy = new TreeNode();
        dummy.left = root;

        while(!(dummy.left == null && dummy.right == null)) {
            List<Integer> leaves = new ArrayList<>();
            findLeavesHelper(root, dummy, leaves);
            res.add(leaves);
        }
        return res;
    }

    void findLeavesHelper(TreeNode node, TreeNode parent, List<Integer> leaves) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            leaves.add(node.val);
            if(parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        findLeavesHelper(node.left, node, leaves);
        findLeavesHelper(node.right, node, leaves);
    }
}
