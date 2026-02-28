package Graph_Data_Structure;

import java.util.*;

public class ShortestPathInUndirectedGraphUsingBFS {
    public static void main(String[] args) {
        int V = 9, E = 10, src = 0;
        int [][]edges = {{0, 1},{0, 3},{1, 2},{3, 4},{4, 5},{2, 6},{5, 6},{6, 7},{6, 8},{7, 8}};
        int[] shortestPath = shortestPath(V, edges, src);
        System.out.println("shortestPath : "+Arrays.toString(shortestPath));
    }

    public static int[] shortestPath(int V, int[][] edges, int src) {
        //create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int []edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        //apply bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        int []dist = new int[V];
        Arrays.fill(dist, -1);
        dist[src] = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            for (int neighbour : adj.get(node)){
                if (dist[neighbour] == -1){
                    dist[neighbour] = dist[node]+1;     //1st occurance is always the answer
                    queue.offer(neighbour);
                }
            }
        }
        return dist;
    }
}
