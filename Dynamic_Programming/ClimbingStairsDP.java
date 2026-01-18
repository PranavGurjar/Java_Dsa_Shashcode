package Dynamic_Programming;

import java.util.Arrays;

public class ClimbingStairsDP {
    public static void main(String[] args) {
        int n = 5;

        System.out.println("climbStairs1 : "+climbStairs1(n));

        System.out.println("climbStairs2 : "+climbStairs2(n));

        System.out.println("climbStairs3 : "+climbStairs3(n));

        System.out.println("climbStairs4 : "+climbStairs4(n));
    }

    //recursion
    //2^N
    public static int climbStairs1(int n) {
        //base case
        if (n<=2){
            return n;
        }
        return climbStairs1(n-1) + climbStairs1(n-2);
    }

    //dynamic programming
    //top down
    //time : O(N)
    //space : O(N) + O(N)
    public static int climbStairs2(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return recur(n, dp);
    }

    public static int recur(int n, int []dp){
        //base case
        if (n<=2){
            dp[n] = n;
            return n;
        }

        if (dp[n] != -1){
            return dp[n];
        }

        dp[n] = climbStairs2(n-1) + climbStairs2(n-2);
        return dp[n];
    }

    //bottom up
    //time : O(N)
    //space : O(N)
    public static int climbStairs3(int n) {
        //base case
        if (n<=2){
            return n;
        }
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int state = 3; state <= n; state++) {
            dp[state] = dp[state-1] + dp[state-2];
        }
        return dp[n];
    }

    //bottom up optimize
    //time : O(N)
    public static int climbStairs4(int n) {
        //base case
        if (n<=2) {
            return n;
        }
        int prev2 = 1;
        int prev1 = 2;
        int ans = 0;
        for (int state = 3; state <= n; state++) {
            ans = prev1 + prev2;
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }
}