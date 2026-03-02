package Graph_Data_Structure;

import java.util.Arrays;

public class RedundantConnection {
    public static void main(String[] args) {
        int [][]edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] redundantConnection = findRedundantConnection(edges);
        System.out.println("redundantConnection : "+ Arrays.toString(redundantConnection));
    }

    static int totalNodes;
    //1 based 1, 2, 3
    public static int[] findRedundantConnection(int[][] edges) {
        totalNodes = edges.length;
        int []res = new int[2];
        DisJointSet dsu = new DisJointSet(totalNodes);
        for (int []edge : edges){
            if (!dsu.unionBySize(edge[0]-1, edge[1]-1)){
                return edge;
            }
        }
        return res;
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