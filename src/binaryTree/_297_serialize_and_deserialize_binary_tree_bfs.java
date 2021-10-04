package binaryTree;
import pojos.TreeNode;

import java.util.*;

public class _297_serialize_and_deserialize_binary_tree_bfs {
    // Encodes a tree to a single string.
    // 1,2,3,null,null,4,5
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                TreeNode node = q.poll();
                if(node != null) {
                    sb.append(node.val + ",");
                    q.add(node.left);
                    q.add(node.right);
                } else {
                    sb.append("#,");
                }
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("#")) return null;
        String[] arr = data.split(",");
        int idx = 1;
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(idx < arr.length) {
            int size = q.size();
            while(size-- > 0) {
                TreeNode node =q.poll();
                if(!arr[idx].equals("#")) {
                    node.left = new TreeNode(Integer.valueOf(arr[idx]));
                    q.add(node.left);
                }
                idx++;
                if(!arr[idx].equals("#")) {
                    node.right = new TreeNode(Integer.valueOf(arr[idx]));
                    q.add(node.right);
                }
                idx++;
            }
        }
        return root;
    }
}
