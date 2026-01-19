package Dynamic_Programming;

import java.util.Arrays;

public class PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abc";
        String text2 = "ace";

        int longSubsequence = longestCommonSubsequence(text1, text2);
        System.out.println("longSubsequence : "+longSubsequence);
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        dp[0][0] = 0;

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    int case1 = dp[i-1][j];
                    int case2 = dp[i][j-1];
                    dp[i][j] = Math.max(case1, case2);
                }
            }
        }
        print(dp);
        return dp[n][m];
    }

    public static void print(int [][]dp){
        int n = dp.length;
        int m = dp[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j]+", ");
            }
            System.out.println();
        }
    }
}
