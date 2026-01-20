package Dynamic_Programming;

import java.util.Arrays;


public class MaximumLengthOfPairChain {
    public static void main(String[] args) {
        int [][]pairs = {{1,2},{2,3},{3,4}};

        int longestChain = findLongestChain(pairs);
        System.out.println("longestChain : "+longestChain);
    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);      //T -> NLogN
        int n = pairs.length;
        int lis[] = new int[n];
        Arrays.fill(lis, 1);
        int maxLen = 1;
        //T -> N^2
        for (int i = 1; i < n; i++) {
            for (int p = 0; p < i; p++) {
                if (pairs[p][1] < pairs[i][0]){
                    lis[i] = Math.max(lis[i], 1+lis[p]);
                }
            }
            if (lis[i] > maxLen){
                maxLen = lis[i];
            }
        }
        return maxLen;
    }
}
