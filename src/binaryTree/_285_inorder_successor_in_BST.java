package binaryTree;

import pojos.TreeNode;

public class _285_inorder_successor_in_BST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode c = null; // candidate
        while(root != null) {
            if(p.val >= root.val) {
                root = root.right;
            } else {
                c = root;
                root = root.left;
            }
        }
        return c;
    }
}
