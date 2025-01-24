import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n]; // 0: unvisited, 1: visiting, 2: safe
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, state)) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean dfs(int node, int[][] graph, int[] state) {
        if (state[node] == 1) return false; // Cycle detected
        if (state[node] == 2) return true;  // Already safe

        state[node] = 1; // Mark as visiting

        for (int neighbor : graph[node]) {
            if (!dfs(neighbor, graph, state)) {
                return false; // If any neighbor is not safe, this node is not safe
            }
        }

        state[node] = 2; // Mark as safe
        return true;
    }
}