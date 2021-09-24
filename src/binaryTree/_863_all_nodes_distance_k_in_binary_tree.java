package binaryTree;

import pojos.TreeNode;
import java.util.*;
public class _863_all_nodes_distance_k_in_binary_tree {
    Map<TreeNode, List<TreeNode>> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        map.put(root, new ArrayList<>());
        buildGraph(root, null);
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();
        q.add(target);
        seen.add(target);
        int k =0;
        while(!q.isEmpty() && k <= K) {
            int size = q.size();
            for(int i = 0;i < size; i++){
                TreeNode node = q.poll();
                if(k == K) {
                    res.add(node.val);
                }
                for(TreeNode neighbor: map.get(node)) {
                    if(seen.contains(neighbor)) continue;
                    q.add(neighbor);
                    seen.add(neighbor);
                }
            }
            k++;
        }
        return res;
    }

    void buildGraph(TreeNode node, TreeNode parent) {
        if(node == null) return;
        if(parent != null) {
            map.computeIfAbsent(parent, e -> new ArrayList<>()).add(node);
            map.computeIfAbsent(node, e-> new ArrayList<>()).add(parent);
        }

        buildGraph(node.left, node);
        buildGraph(node.right, node);
    }
}
