package graph;
import java.util.*;
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class _133_clone_graph {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        // write your code here
        Set<Node> nodeSet = getAllNodes(node);
        Map<Node, Node> map = cloneNodes(nodeSet);
        makeConnection(map);
        return map.get(node);
    }

    private void makeConnection(Map<Node, Node> map) {
        for (Node origNode : map.keySet()) {
            Node copy = map.get(origNode);
            for (Node neighbor : origNode.neighbors) {
                Node copiedNeighbor = map.get(neighbor);
                copy.neighbors.add(copiedNeighbor);
            }
        }
    }

    private Map<Node, Node> cloneNodes(
            Set<Node> nodeSet) {
        Map<Node, Node> map = new HashMap<>();
        for (Node node : nodeSet) {
            map.put(node, new Node(node.val));
        }
        return map;
    }

    private Set<Node> getAllNodes(Node node) {
        Set<Node> nodeSet = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        nodeSet.add(node);
        while (!q.isEmpty()) {
            Node curNode = q.poll();
            for (Node neighbor : curNode.neighbors) {
                if (!nodeSet.contains(neighbor)) {
                    q.add(neighbor);
                    nodeSet.add(neighbor);
                }
            }
        }
        return nodeSet;
    }
}
