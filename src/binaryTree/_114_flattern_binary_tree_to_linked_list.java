package binaryTree;

import pojos.TreeNode;

public class _114_flattern_binary_tree_to_linked_list {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
