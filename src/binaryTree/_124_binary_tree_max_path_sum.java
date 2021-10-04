package binaryTree;

import pojos.TreeNode;
import utility.BinaryTreeBuilder;

import java.util.*;

public class _124_binary_tree_max_path_sum {
    public static void main(String[] args) {
        TreeNode root = new BinaryTreeBuilder().buildBinaryTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1});
        new _124_binary_tree_max_path_sum().maxPathSum(root);
    }

    Map<TreeNode, Integer> left = new HashMap<>();
    Map<TreeNode, Integer> right = new HashMap<>();

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    int dfs(TreeNode root) {
        if(root == null) return 0;
        int goLeft = dfs(root.left);
        int goRight = dfs(root.right);

        // 3 ways: stop here, go left, go right
        int ret = Math.max(root.val, Math.max(root.val + goLeft, root.val+goRight));
        res = Math.max(res, Math.max(ret, root.val + goLeft + goRight));
        return ret;
    }
}
