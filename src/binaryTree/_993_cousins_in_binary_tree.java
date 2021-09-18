package binaryTree;

import pojos.TreeNode;

public class _993_cousins_in_binary_tree {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] xR = getDepthAndParent(root, 0, x, -1);
        int[] yR = getDepthAndParent(root, 0, y, -1);
        return xR != null && yR != null && xR[0] == yR[0] && xR[1] != yR[1];
    }

    int[] getDepthAndParent(TreeNode node, int curDepth, int target, int parent) {
        if(node == null) return null;
        if(node.val == target) {
            return new int[] {curDepth, parent};
        }
        int[] left = getDepthAndParent(node.left, curDepth+1, target, node.val);
        if(left != null)
            return left;

        int[] right = getDepthAndParent(node.right, curDepth+1, target, node.val);
        if(right != null)
            return right;

        return null;
    }
}
