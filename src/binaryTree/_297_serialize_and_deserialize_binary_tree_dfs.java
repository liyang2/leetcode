package binaryTree;

import pojos.TreeNode;
import java.util.*;
public class _297_serialize_and_deserialize_binary_tree_dfs {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        recurSer(root, sb);
        return sb.toString();
    }

    void recurSer(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val+",");
        recurSer(node.left, sb);
        recurSer(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("#,")) return null;
        LinkedList<String> list = new LinkedList( Arrays.asList(data.split(",")));
        return recurDer(list);
    }

    TreeNode recurDer(LinkedList<String> list) {
        if(list.isEmpty()) return null;
        String str = list.remove(0);
        if(str.equals("#")) return null;

        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = recurDer(list);
        node.right = recurDer(list);
        return node;
    }
}
