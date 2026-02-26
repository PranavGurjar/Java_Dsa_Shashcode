package Graph_Data_Structure;

import java.util.ArrayList;

public class CycleDetectionInDirectedGraphsUsingDFS {
    public static void main(String[] args) {

    }

    public boolean isCyclic(int V, int[][] edges) {
        // ✅ build adjacency list (DIRECTED graph)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);   // directed edge u -> v
        }

        boolean []visited = new boolean[V];
        boolean []pathVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]){
                if (dfs(i, visited, adj, pathVisited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int src, boolean []visited,
                       ArrayList<ArrayList<Integer>> adj,
                       boolean []pathVisited){
        visited[src] = true;
        pathVisited[src] = true;
        for (int neighbour : adj.get(src)){
            if (pathVisited[neighbour]){
                return true;
            }
            else if (visited[neighbour]){
                continue;
            }
            else {
                if (dfs(neighbour, visited, adj, pathVisited)){
                    return true;
                }
            }
        }
        pathVisited[src] = false;
        return false;
    }
}