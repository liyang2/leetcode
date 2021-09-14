package binaryTree;

import pojos.TreeNode;

public class _897_increasing_order_search_tree {
    TreeNode prev;
    TreeNode newRoot;

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return newRoot;
    }

    void inorder(TreeNode node) {
        if(node ==null) return;

        inorder(node.left);
        if(newRoot == null)
            newRoot = node;
        node.left = null;
        if(prev != null)
            prev.right = node;
        prev = node;
        inorder(node.right);
    }
}
