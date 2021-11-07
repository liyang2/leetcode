package binaryTree;

import pojos.TreeNode;
import java.util.*;

public class _105_construct_binary_tree_from_preorder_and_inorder {
    int preIndex = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeRecur(preorder, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTreeRecur(int[] preorder, int[] inorder, int left, int right) {
        if(left > right)
            return null;
        TreeNode node = new TreeNode(preorder[preIndex++]);
        int indexInorder = inorderMap.get(node.val);
        node.left = buildTreeRecur(preorder, inorder, left, indexInorder-1);
        node.right = buildTreeRecur(preorder, inorder, indexInorder+1, right);
        return node;
    }
}
