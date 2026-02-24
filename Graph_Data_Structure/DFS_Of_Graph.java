package Graph_Data_Structure;

import java.util.ArrayList;

public class DFS_Of_Graph {
    public static void main(String[] args) {
        int [][]adjArr = {{2, 3, 1},{0},{0, 4},{0},{2}};

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // convert int[][] -> ArrayList<ArrayList<Integer>>
        for (int i = 0; i < adjArr.length; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < adjArr[i].length; j++) {
                adj.get(i).add(adjArr[i][j]);
            }
        }

        ArrayList<Integer> dfsGraph = dfsGraph(adj);
        System.out.println("dfsGraph : "+dfsGraph);
    }

    public static ArrayList<Integer> dfsGraph(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();

        ArrayList<Integer> res = new ArrayList<>();
        boolean []visited = new boolean[V];     //0 to v-1
        for (int i = 0; i < visited.length; i++) {
            if (!(visited[i])){
                dfs(i, visited, adj, res);
            }
        }
        return res;
    }

    public static void dfs(int node, boolean visited[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res){
        visited[node] = true;
        res.add(node);
        for (int neighbour : adj.get(node)){
            if (!(visited[neighbour])){
                dfs(neighbour, visited, adj, res);
            }
        }
    }
}