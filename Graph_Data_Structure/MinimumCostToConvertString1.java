package Graph_Data_Structure;

import java.util.Arrays;

public class MinimumCostToConvertString1 {
    public static void main(String[] args) {
        String source = "abcd", target = "acbe";
        char[] original = {'a','b','c','c','e','d'};
        char[] changed  = {'b','c','b','e','b','e'};
        int []cost = {2,5,5,1,2,20};
        long minimumCost = minimumCost(source, target, original, changed, cost);
        System.out.println("minimumCost : "+minimumCost);
    }
    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int [][]dis = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
            dis[i][i] = 0;
        }
            //using ascii to convert into index
            for (int i = 0; i < cost.length; i++) {

                int start = original[i] - 'a';
            int end = changed[i] - 'a';
            dis[start][end] = Math.min(dis[start][end], cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (dis[i][k] < Integer.MAX_VALUE){
                    for (int j = 0; j < 26; j++) {
                        if (dis[k][j] < Integer.MAX_VALUE){
                            dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                        }
                    }
                }
            }
        }
        long ans = 0L;
        for (int i = 0; i < source.length(); i++) {
            int c1 = source.charAt(i) - 'a';
            int c2 = target.charAt(i) - 'a';
            if (dis[c1][c2] == Integer.MAX_VALUE){
                return -1L;
            }
            else {
                ans += (long) dis[c1][c2];
            }
        }
        return ans;
    }
}