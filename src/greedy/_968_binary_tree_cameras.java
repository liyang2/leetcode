package greedy;
import pojos.TreeNode;

import java.util.*;

public class _968_binary_tree_cameras {
    int res = 0;
    Set<TreeNode> covered;

    public int minCameraCover(TreeNode root) {
        covered = new HashSet<>();
        covered.add(null);

        dfs(root, null);
        return res;
    }


    // post-order traversal
    private void dfs(TreeNode node, TreeNode parent) {
        if(node == null) return;
        dfs(node.left, node);
        dfs(node.right, node);

        if(!covered.contains(node.left) || !covered.contains(node.right)) {
            covered.add(node);
            covered.add(node.left);
            covered.add(node.right);
            covered.add(parent);
            res ++;
        }

        // all children are covered
        if(parent == null && !covered.contains(node)) {
            covered.add(node);
            res++;
        }
    }
}
