package binaryTree;
import pojos.TreeNode;

import java.util.*;
public class _103_binary_tree_zigzag_level_order_traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        List<List<Integer>> res = new ArrayList<>();
        while(!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> list = new LinkedList<>();
            while(size-- > 0) {
                TreeNode node = q.poll();
                if(leftToRight) {
                    list.add(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            res.add(list);
            leftToRight = !leftToRight;
        }
        return res;
    }
}
