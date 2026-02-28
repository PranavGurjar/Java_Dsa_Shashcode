package Graph_Data_Structure;

import java.util.ArrayList;
import java.util.Stack;

public class Kahn_s_Algorithm_Topological_Sort_Using_DFS {
    public static void main(String[] args) {
        int [][]edges = {{1, 3},{2, 3},{4, 1},{4, 0},{5, 0},{5, 2}};
        int V = 6, E = 6;
        ArrayList<Integer> topoSortDFS = topoSortDFS(V, edges);
        System.out.println("topoSortDFS : "+topoSortDFS);
    }

    public static ArrayList<Integer> topoSortDFS(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]){
                dfs(i, adj, visited, stack);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }

    public static void dfs(int src, ArrayList<ArrayList<Integer>> adj,
                    boolean[] visited, Stack<Integer> stack){
        visited[src] = true;
        for (int neighbour : adj.get(src)){
            if (!visited[neighbour]){
                dfs(neighbour, adj, visited, stack);
            }
        }
        stack.push(src);
    }
}