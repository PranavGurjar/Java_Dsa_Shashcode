package Graph_Data_Structure;

import java.util.ArrayList;
import java.util.Stack;

public class Strongly_Connected_Components_Kosaraju_Algorithm {
    public static void main(String[] args) {
        int V = 5, E = 5;
        int [][]edges = {{0, 2},{0, 3},{1, 0},{2, 1},{3, 4}};
        int kosaraju = kosaraju(V, edges);
        System.out.println("kosaraju : "+kosaraju);
    }

    public static int kosaraju(int V, int[][] edges) {
        // 1. Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // edges[i] = {u, v}
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }

        boolean []visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]){
                dfs(i, visited, adj, stack);
            }
        }

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < V; i++) {
            visited[i] = false;
            for (Integer it : adj.get(i)){
                adjList.get(it).add(i);
            }
        }
        int count = 0;
        while (!stack.isEmpty()){
            int node = stack.peek();
            stack.pop();
            if (!visited[node]){
                count++;
                dfsCount(node, visited, adjList);
            }
        }
        return count;
    }

    public static void dfs(int node, boolean []visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack){
        visited[node] = true;
        for (Integer it : adj.get(node)){
            if (!visited[it]){
                dfs(it, visited, adj, stack);
            }
        }
        stack.push(node);
    }

    public static void dfsCount(int node, boolean []visited, ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        for (Integer it : adj.get(node)){
            if (!visited[it]){
                dfsCount(it, visited, adj);
            }
        }
    }
}

