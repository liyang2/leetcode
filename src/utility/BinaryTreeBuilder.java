package utility;

import pojos.TreeNode;

import java.util.*;

public class BinaryTreeBuilder {
    public static void main(String[] args) {
        BinaryTreeBuilder binaryTreeBuilder = new BinaryTreeBuilder();
        Integer[] arr = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = binaryTreeBuilder.buildBinaryTree(arr);
        System.out.println("");
    }
    public TreeNode buildBinaryTree(Integer[] arr) {
        int idx= 1;
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> parentQ = new LinkedList<>();
        parentQ.add(root);

        while (!parentQ.isEmpty() && idx < arr.length) {
            int size = parentQ.size();
            while (size-- > 0) {
                TreeNode p = parentQ.poll();
                if (arr[idx] != null) {
                    p.left = new TreeNode(arr[idx]);
                    parentQ.add(p.left);
                }
                idx++;
                if (arr[idx] != null) {
                    p.right = new TreeNode(arr[idx]);
                    parentQ.add(p.right);
                }
                idx++;
            }
        }
        return root;
    }
}
