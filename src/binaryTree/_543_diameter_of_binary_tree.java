package binaryTree;

import pojos.TreeNode;

public class _543_diameter_of_binary_tree {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        pathToLeaf(root);

        //leafToParent(root);

        return res;
    }

    // This is more intuitive but less concise
    private int pathToLeaf(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 0;

        int left = root.left == null ? 0 : 1+pathToLeaf(root.left);
        int right = root.right == null ? 0 : 1+pathToLeaf(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right);
    }

    // This is less intuitive but more concise
    private int leafToParent(TreeNode root) {
        if(root == null)
            return 0;

        int left = pathToLeaf(root.left);
        int right = pathToLeaf(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right)+1;
    }
}
