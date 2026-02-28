package Graph_Data_Structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Kahn_s_Algorithm_Topological_Sort_Using_BFS {
    public static void main(String[] args) {
        int [][]edges = {{1, 3},{2, 3},{4, 1},{4, 0},{5, 0},{5, 2}};
        int V = 6, E = 6;
        ArrayList<Integer> topoSortBFS = topoSortBFS(V, edges);
        System.out.println("topoSortBFS : "+topoSortBFS);
    }

    public static ArrayList<Integer> topoSortBFS(int V, int[][] edges) {
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
            return new ArrayList<>();
        }
//        int []ans = new int[V];
//        for (int i = 0; i < V; i++) {
//            ans[i] = res.get(i);
//        }
//        return ans;
        return res;
    }
}

