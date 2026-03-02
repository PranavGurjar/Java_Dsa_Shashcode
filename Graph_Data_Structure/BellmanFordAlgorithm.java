package Graph_Data_Structure;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgorithm {
    public static void main(String[] args) {
        int V = 5, src = 0;
        int [][]edges = {
                            {1, 3, 2},
                            {4, 3, -1},
                            {2, 4, 1},
                            {1, 2, 1},
                            {0, 1, 5}
                        };
        int[] bellmanFord = bellmanFord(V, edges, src);
        System.out.println("bellmanFord : "+Arrays.toString(bellmanFord));
    }

    public static int[] bellmanFord(int V, int[][] edges, int src) {
        int []dist = new int[V];
        Arrays.fill(dist, (int) 1e8);
        dist[src] = 0;

        for (int i = 0; i < V-1; i++) {
            boolean isChange = false;
            for (int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (dist[u]!=(int) 1e8 && dist[u]+w < dist[v]){
                    dist[v] = dist[u]+w;
                    isChange = true;
                }
            }
            if (!isChange){
                break;  //if cur relation is not changing and dist then no need to check further!
            }
        }
        for (int i = 0; i < V-1; i++) {
            for (int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (dist[u]!=(int) 1e8 && dist[u]+w < dist[v]){
                    return new int[]{-1};
//                    dist[v] = dist[u]+w;
                }
            }
        }
        return dist;
    }
}