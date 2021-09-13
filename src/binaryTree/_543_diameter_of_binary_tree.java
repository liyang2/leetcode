package binaryTree;

import pojos.TreeNode;

public class _543_diameter_of_binary_tree {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }

    int depth(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        res = Math.max(res, leftDepth + rightDepth);


        return Math.max(leftDepth, rightDepth)+1;
    }
}
