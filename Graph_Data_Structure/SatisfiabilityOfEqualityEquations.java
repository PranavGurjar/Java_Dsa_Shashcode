package Graph_Data_Structure;

import java.util.ArrayList;

public class SatisfiabilityOfEqualityEquations {
    public static void main(String[] args) {
        String []equations = {"a==b","b!=a"};
        boolean equationsPossible = equationsPossible(equations);
        System.out.println("equationsPossible : "+equationsPossible);
    }
    public static boolean equationsPossible(String[] equations) {
        DisJointSet dsu = new DisJointSet(26);
        ArrayList<int[]> notEqualEdges = new ArrayList<>();
        for (String equation : equations){
            int u = equation.charAt(0)-'a';
            int v = equation.charAt(3)-'a';
            //construct graphs using "equal to" equations
            if (equation.charAt(1)=='='){
                dsu.unionBySize(u, v);
            }
            else {
                notEqualEdges.add(new int[]{u, v});
            }
        }
        for (int []edge : notEqualEdges){
            int u = edge[0];
            int v = edge[1];
            if (dsu.findRootParent(u) == dsu.findRootParent(v)){
                return false;
            }
        }
        return true;
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