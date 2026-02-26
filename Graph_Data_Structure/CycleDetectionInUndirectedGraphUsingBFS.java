package Graph_Data_Structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionInUndirectedGraphUsingBFS {
    public static void main(String[] args) {
//        Input: V = 4, E = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
//        Output: true
    }

    public boolean isCycleBFS(int V, int[][] edges) {
        // ✅ build adjacency list from edges
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);   // undirected
        }

        boolean []visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && checkIfCycle(i, adjList, visited)){
                return true;
            }
        }
        return false;
    }

    public boolean checkIfCycle(int src, ArrayList<ArrayList<Integer>> adjList, boolean []visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, -1});
        visited[src] = true;
        while (!queue.isEmpty()){
            int []pair = queue.poll();
            int node = pair[0];
            int parent = pair[1];
            for (int neighbour : adjList.get(node)){
                if (neighbour == parent) continue;
                if (visited[neighbour]) return true;
                else {
                    queue.offer(new int[]{neighbour, node});
                    visited[neighbour] = true;
                }
            }
        }
        return false;
    }
}