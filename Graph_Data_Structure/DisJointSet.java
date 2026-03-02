package Graph_Data_Structure;

public class DisJointSet {
    int []parent;
    int []rank;
    int []size;
    int components;

    public DisJointSet(int nodes) {
        this.parent = new int[nodes];
        this.rank = new int[nodes];
        this.size = new int[nodes];
        this.components = nodes;
        for (int i = 0; i < nodes; i++) {
            this.parent[i] = i;
            this.rank[i] = 0;
            this.size[i] = 1;
        }
    }

    public int findRootParent(int node){
        if (node == parent[node]){
            return node;
        }
        parent[node] = findRootParent(parent[node]);
        return parent[node];
    }
    public void unionByRank(int node1, int node2){
        //1. find the root parent
        int rootParent1 = findRootParent(node1);
        int rootParent2 = findRootParent(node2);
        if (rootParent1 == rootParent2){
            return;
        }
        components--;
        //2, union of component
        if (rank[rootParent1] < rank[rootParent2]){
            parent[rootParent1] = rootParent2;
        }else if (rank[rootParent2] < rank[rootParent1]){
            parent[rootParent2] = rootParent1;
        }else{
            parent[rootParent2] = rootParent1;
            rank[rootParent1]++;
        }    }


    public void unionBySize(int node1, int node2){
        //1. find the root parent
        int rootParent1 = findRootParent(node1);
        int rootParent2 = findRootParent(node2);
        if (rootParent1 == rootParent2){
            return;
        }
        components--;
        //2, union of component
        if (size[rootParent1] < size[rootParent2]){
            parent[rootParent1] = rootParent2;
            size[rootParent2] += size[rootParent1];
        }else {
            parent[rootParent2] = rootParent1;
            size[rootParent1] += size[rootParent2];
        }
    }

    public static void main(String[] args) {
//        DisJointSet dsu = new DisJointSet(4);
//        System.out.println("total component -> "+dsu.components);
//        System.out.println(dsu.findRootParent(0) == dsu.findRootParent(3));
//        dsu.unionByRank(0,3);
//        System.out.println("total component -> "+dsu.components);
//        System.out.println(dsu.findRootParent(0) == dsu.findRootParent(3));
//


        DisJointSet dsu = new DisJointSet(4);
        System.out.println("total component -> "+dsu.components);
        System.out.println(dsu.findRootParent(0) == dsu.findRootParent(3));
        dsu.unionBySize(0,3);
        System.out.println("total component -> "+dsu.components);
        System.out.println(dsu.findRootParent(0) == dsu.findRootParent(3));

    }
}
