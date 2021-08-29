package binaryTree;

import pojos.TreeNode;

public class _663_equal_tree_partition {
    public boolean checkEqualTree(TreeNode root) {
        int sum = getSum(root);
        if(sum % 2 != 0) return false;
        return recur(root, sum/2);
    }

    boolean recur(TreeNode root, int target) {
        if(root == null) return false;

        if(root.left != null && getSum(root.left) == target) return true;
        if(root.right != null && getSum(root.right) == target) return true;
        return recur(root.left, target) || recur(root.right, target);
    }

    int getSum(TreeNode root) {
        if(root == null) return 0;
        return root.val + getSum(root.left) + getSum(root.right);
    }
}
