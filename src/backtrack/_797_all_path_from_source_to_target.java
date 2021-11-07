package backtrack;
import java.util.*;
public class _797_all_path_from_source_to_target {
    private List<List<Integer>> res;
    private int[][] graph;
    private int n;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        this.graph = graph;
        this.n = graph.length;

        dfs(0, new ArrayList<>());
        return res;
    }

    private void dfs(int start, List<Integer> path) {
        path.add(start);
        if (start == n - 1) {
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        for (int next : graph[start]) {
            dfs(next, path);
        }
        path.remove(path.size() - 1);
    }
}
