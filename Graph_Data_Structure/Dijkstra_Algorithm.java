package Graph_Data_Structure;

import java.util.*;

public class Dijkstra_Algorithm {
    public static void main(String[] args) {
        int V = 5, src = 0;
        int [][]edges = {{0, 1, 4},{0, 2, 8},{1, 4, 6},{2, 3, 2},{3, 4, 10}};
        int[] dijkstra = dijkstra(V, edges, src);
        System.out.println("Dijkstra : "+Arrays.toString(dijkstra));
    }

    public static int[] dijkstra(int V, int[][] edges, int src) {

        // store (to, weight)
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});   // remove if directed
        }

        //{node, dist}
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[1] - p2[1];
            }
        });

//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int []dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.offer(new int[]{src, 0});
        while (!pq.isEmpty()){
            int []pair = pq.poll();
            int u = pair[0];
            int d = pair[1];
            if (d > dist[u]) continue;
            for (int[] neighbour : adj.get(u)){
                int v = neighbour[0];
                int w = neighbour[1];
                if (dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        return dist;
    }
}