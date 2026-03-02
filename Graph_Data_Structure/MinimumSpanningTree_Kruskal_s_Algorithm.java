package Graph_Data_Structure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumSpanningTree_Kruskal_s_Algorithm {
    public static void main(String[] args) {
        int V = 3, E = 3;
        int [][]edges = {{0, 1, 5},{1, 2, 3},{0, 2, 1}};
        int spanningTree = spanningTree(V, edges);
        System.out.println("spanningTree : "+spanningTree);
    }

    public static int spanningTree(int V, int[][] edges) {
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

        //(u, v, weight)
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair1[2] - pair2[2];
            }
        });

        //insert edges in pq
        for (int i = 0; i < V; i++) {
            for (int []edge : adj.get(i)){
                pq.offer(new int[]{i, edge[0], edge[1]});
            }
        }
        DisJointSet dsu = new DisJointSet(V);
        int sum = 0;
        while (!pq.isEmpty()){
            int object[] = pq.poll();
            int u = object[0];
            int v = object[1];
            int weight = object[2];
            if (dsu.unionBySize(u, v)){
                sum += weight;
            }
//            else {
//                //store the edges
//            }
        }
        return sum;
    }

    static class DisJointSet {
        static int[] parent;
        static int[] size;
        public DisJointSet(int nodes) {
            this.parent = new int[nodes];
            this.size = new int[nodes];
            for (int i = 0; i < nodes; i++) {
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }
        public static int findRootParent(int node) {
            if (node == parent[node]) {
                return node;
            }
            parent[node] = findRootParent(parent[node]);
            return parent[node];
        }
        public static boolean unionBySize(int node1, int node2) {
            //1. find the root parent
            int rootParent1 = findRootParent(node1);
            int rootParent2 = findRootParent(node2);
            if (rootParent1 == rootParent2) {
                return false;
            }
            //2, union of component
            if (size[rootParent1] < size[rootParent2]) {
                parent[rootParent1] = rootParent2;
                size[rootParent2] += size[rootParent1];
            } else {
                parent[rootParent2] = rootParent1;
                size[rootParent1] += size[rootParent2];
            }
            return true;
        }
    }
}