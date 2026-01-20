package Dynamic_Programming;

import java.util.Arrays;

public class UniquePaths1 {
    public static void main(String[] args) {
        int m = 3, n = 2;

        int uniquePaths1 = uniquePaths1(m, n);
        System.out.println("uniquePaths1 : "+ uniquePaths1);

        int uniquePaths2 = uniquePaths2(m, n);
        System.out.println("uniquePaths2 : "+ uniquePaths2);

        int uniquePaths3 = uniquePaths3(m, n);
        System.out.println("uniquePaths3 : "+ uniquePaths3);

        int uniquePaths4 = uniquePaths4(m, n);
        System.out.println("uniquePaths4 : "+ uniquePaths4);
    }

    //recursive approach //T -> 2^m * 2^n
    public static int uniquePaths1(int m, int n) {
        return recur1(m-1, n-1);
    }
    public static int recur1(int m, int n){
        //base case
        if (m == 0 && n == 0){
            return 1;
        }

        if (m<0 || n<0){
            return 0;
        }

        int ways = recur1(m-1, n) + recur1(m, n-1);
        return ways;
    }

    //top down approach //T -> 2^m * 2^n
    public static int uniquePaths2(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return recur2(m, n, dp);
    }
    public static int recur2(int m, int n, int [][]dp){
        //base case
        if (m == 1 && n == 1){
            dp[m][n] = 1;
            return 1;
        }

        if (m==0 || n==0){
            dp[m][n] = 0;
            return 0;
        }
        if (dp[m][n] != -1){
            return dp[m][n];
        }
        int ways = recur2(m-1, n, dp) + recur2(m, n-1, dp);
        dp[m][n] = ways;
        return dp[m][n];
    }

    //bottom up approach
    public static int uniquePaths3(int m, int n) {
        int dp[][] = new int[m+1][n+1];

        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                } else if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }

    //bottom up space optimize approach     //T -> M*N
    public static int uniquePaths4(int m, int n) {
        int prev[] = new int[n+1];

        for (int i = 1; i < m+1; i++) {
            int cur[] = new int[n+1];
            for (int j = 0; j < n+1; j++) {
                if (i == 0 || j == 0){
                    cur[j] = 0;
                } else if (i == 1 && j == 1) {
                    cur[j] = 1;
                }else {
                    cur[j] = prev[j] + cur[j-1];
                }
            }
            prev = cur;
        }
        return prev[n];
    }
}