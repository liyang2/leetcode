package binaryTree;

import pojos.TreeNode;

public class _222_count_complete_tree_nodes {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int count = new _222_count_complete_tree_nodes().countNodes(root);
        System.out.println(count);

    }
    // root is not null
    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root.left != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }

    // idx is 0 based
    private boolean exists(int index, TreeNode root, int depth) {
        int left = 0, right = (int)Math.pow(2, depth) - 1;
        // [0, mid] is left half,
        // [mid+1, right] is right half
        for (int i = 0; i < depth; i++) {
            int mid = left + (right - left) / 2;
            if (index <= mid) {
                root = root.left;
                right = mid;
            } else {
                root = root.right;
                left = mid + 1;
            }
        }
        return root != null;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = getDepth(root);
        int res = (int)Math.pow(2, depth) - 1; // all the nodes except bottom level
        int left = 0, right = res;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (exists(mid, root, depth)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (exists(right, root, depth)) {
            res += right + 1;
        } else {
            res += left + 1;
        }
        return res;
    }
}
