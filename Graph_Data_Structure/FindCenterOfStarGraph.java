package Graph_Data_Structure;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class FindCenterOfStarGraph {
    public static void main(String[] args) {
        int[][] edges = {{1, 2},{2, 3},{4, 2}};

        int center1 = findCenter1(edges);
        System.out.println("center1 : " + center1);

        int center2 = findCenter2(edges);
        System.out.println("center2 : " + center2);

        int center3 = findCenter3(edges);
        System.out.println("center3 : " + center3);
    }


    public static int findCenter1(int[][] edges) {
        int []pair1 = edges[0]; //(v1, v2)
        int []pair2 = edges[1]; //(v1, v3) - (v2, v3)

        if (pair1[0] == pair2[0] || pair1[0] == pair2[1]){
            return pair1[0];
        }
        return pair1[1];
    }

    public static int findCenter2(int[][] edges) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int totalEdges = edges.length;
        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            freqMap.put(v1, freqMap.getOrDefault(v1, 0)+1);
            freqMap.put(v2, freqMap.getOrDefault(v2, 0)+1);
            if (freqMap.get(v1) == totalEdges){
                return v1;
            }
            if (freqMap.get(v2) == totalEdges){
                return v2;
            }
        }
        return -1;
    }

    public static int findCenter3(int[][] edges) {
        int totalEdges = edges.length;
        int []degree = new int[totalEdges+2];
        for (int []edge : edges){
            int u = edge[0];
            int v = edge[1];
            degree[u]++;
            degree[v]++;
        }
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == totalEdges){
                return i;
            }
        }
        return -1;
    }

}

