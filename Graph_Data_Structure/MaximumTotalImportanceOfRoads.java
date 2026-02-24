package Graph_Data_Structure;

import java.util.Arrays;

public class MaximumTotalImportanceOfRoads {
    public static void main(String[] args) {
        int[][] roads = {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}};
        int n = 5;
        long maximumImportance = maximumImportance(n, roads);
        System.out.println("maximumImportance : "+maximumImportance);
    }

    public static long maximumImportance(int n, int[][] roads) {
        //find the degree
        long []degree = new long[n];
        for (int []edge : roads){
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Arrays.sort(degree);
        long res = 0;
        long label = 1;
        for (int i = 0; i < n; i++) {
            res += (degree[i] * label);
            label++;
        }
        return res;
    }
}