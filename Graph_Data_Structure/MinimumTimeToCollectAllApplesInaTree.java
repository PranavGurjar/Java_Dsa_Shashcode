package Graph_Data_Structure;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeToCollectAllApplesInaTree {
    public static void main(String[] args) {
//        Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]],
//        hasApple = [false,false,true,false,true,true,false]
//        Output: 8

    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        //adj list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int []edge : edges){
            int from = edge[0];
            int to = edge[1];
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        return dfs(0, -1, adjList, hasApple);
    }

    private int dfs(int src, int parent, List<List<Integer>> adjList, List<Boolean> hasApple) {
        int totalTime = 0;
        for (int neighbour : adjList.get(src)){
            if (neighbour == parent) continue;
            int timeTakenByChild = dfs(neighbour, src, adjList, hasApple);
            if (timeTakenByChild > 0 || hasApple.get(neighbour)){
                totalTime += timeTakenByChild+2;
            }
        }
        return totalTime;
    }
}