package Graph_Data_Structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Of_Graph {
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

        ArrayList<Integer> graph1 = bfsGraph1(adj);
        System.out.println("graph1 : "+graph1);

        ArrayList<Integer> graph2 = bfsGraph2(adj);
        System.out.println("graph2 : "+graph2);
    }

    public static ArrayList<Integer> bfsGraph1(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();

        boolean []visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]){
                bfs(i, visited, queue, res, adj);
            }
        }

        return res;
    }

    public static void bfs(int source, boolean []visited,
                           Queue<Integer> queue,
                           ArrayList<Integer> res,
                           ArrayList<ArrayList<Integer>> adj){
        visited[source] = true;
        queue.offer(source);
        while (!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            for (int neighbour : adj.get(node)){
                if (!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
    }

    public static ArrayList<Integer> bfsGraph2(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();

        boolean []visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.offer(0);
        while (!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            for (int neighbour : adj.get(node)){
                if (!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
        return res;
    }


}