package binaryTree;

import pojos.TreeNode;
import java.util.*;

public class _938_range_sum_BST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        if(root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else if(root.val > high) {
            return rangeSumBST(root.left, low, high);
        } else {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
    }

    public int rangeSumBST_iterative(TreeNode root, int low, int high) {
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node != null) {
                if(node.val < low) {
                    stack.push(node.right);
                } else if(node.val > high) {
                    stack.push(node.left);
                } else {
                    res += node.val;
                    stack.push(node.left);
                    stack.push(node.right);
                }
            }
        }
        return res;
    }
}
