package Graph_Data_Structure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumSpanningTree_Prim_s_Algorithm {
    public static void main(String[] args) {
        int V = 3, E = 3;
        int [][]edges = {{0, 1, 5},{1, 2, 3},{0, 2, 1}};
        int spanningTree = spanningTree(V, edges);
        System.out.println("spanningTree : "+spanningTree);
    }

    public static int spanningTree(int V, int [][] edges) {
        // adjacency list : (to, weight)
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // edges[i] = {u, v, w}
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});   // undirected graph
        }

        //(parent, node, weight)
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair1[2] - pair2[2];
            }
        });

        int sum = 0;
        ArrayList<int[]> edge = new ArrayList<>();
        boolean []visited = new boolean[V];
        pq.offer(new int[]{-1, 0, 0});
        while (!pq.isEmpty()){
            //ELogE
            int []object = pq.poll();
            int parent = object[0];
            int node = object[1];
            int weight = object[2];

            if (visited[node]) continue;
            visited[node] = true;
            if (parent != -1){
                edge.add(new int[]{parent, node});
                sum += weight;
            }
            //VLogV
            for (int []neighbourObject : adj.get(node)){
                int neighbourNode = neighbourObject[0];
                int neighbourWeight = neighbourObject[1];
                if (!visited[neighbourNode]){
                    pq.offer(new int[]{node, neighbourNode, neighbourWeight});
                }
            }
        }
        return sum;
    }
}