package binaryTree;

import pojos.TreeNode;

public class _1008_construct_binary_search_tree_from_preorder_traversal {
    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorder(int[] preorder, int upperBound) {
        if(index == preorder.length || preorder[index] > upperBound)
            return null;
        TreeNode node = new TreeNode(preorder[index++]);
        node.left = bstFromPreorder(preorder, node.val);
        node.right = bstFromPreorder(preorder, upperBound);
        return node;
    }
}
