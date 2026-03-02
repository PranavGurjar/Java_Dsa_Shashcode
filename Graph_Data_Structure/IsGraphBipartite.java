package Graph_Data_Structure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    public static void main(String[] args) {
        int [][]graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        boolean bipartite1 = isBipartite1(graph);
        System.out.println("bipartite1 : "+bipartite1);
        boolean bipartite2 = isBipartite2(graph);
        System.out.println("bipartite2 : "+bipartite2);
    }

    public static boolean isBipartite1(int[][] graph) {
          int n = graph.length;
          int []color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1){
                if (!color(i, graph, color)){
                    return false;
                }
            }
        }
        return true;
    }

    //BFS
    private static boolean color(int src, int[][] graph, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        color[src] = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            for (int neighbour : graph[node]){
                if (color[neighbour] == -1){
                    color[neighbour] = 1 - color[node];
                    queue.offer(neighbour);
                }
                else if (color[neighbour] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBipartite2(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, graph, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    // DFS
    private static boolean dfs(int node, int currColor, int[][] graph, int[] color) {
        color[node] = currColor;
        for (int neighbour : graph[node]) {
            if (color[neighbour] == -1) {
                if (!dfs(neighbour, 1 - currColor, graph, color)) {
                    return false;
                }
            }
            else if (color[neighbour] == currColor) {
                return false;
            }
        }
        return true;
    }
}