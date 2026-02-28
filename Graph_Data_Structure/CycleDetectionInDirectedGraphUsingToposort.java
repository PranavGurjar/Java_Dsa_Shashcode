package Graph_Data_Structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionInDirectedGraphUsingToposort {
    public static void main(String[] args) {
        int V = 4;
        int [][]edges = {{0, 1},{1, 2},{2, 0},{2, 3}};
        boolean cyclic = isCyclic(V, edges);
        System.out.println("cyclic : "+cyclic);
    }

    public static boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        // build graph
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }

        int []inDegree = new int[V];
        for (int u = 0; u < adj.size(); u++) {
            for (int v : adj.get(u)){
                //u->v
                inDegree[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0){
                queue.offer(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            for (int neighbour : adj.get(node)){
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }
        if (res.size() != V){
            return true;    //cycle
        }
        return false;
    }
}
