package Dynamic_Programming;

import java.util.Arrays;


public class MinCostClimbingStairs {
    public static void main(String[] args) {
//        int []cost = {10, 15, 20};
        int []cost = {1,100,1,1,1,100,1,1,100,1};
        int minCostClimbingStairs1 = minCostClimbingStairs1(cost);
        System.out.println("minCostClimbingStairs1 : "+minCostClimbingStairs1);

        int minCostClimbingStairs2 = minCostClimbingStairs2(cost);
        System.out.println("minCostClimbingStairs2 : "+minCostClimbingStairs2);

        int minCostClimbingStairs3 = minCostClimbingStairs3(cost);
        System.out.println("minCostClimbingStairs3 : "+minCostClimbingStairs3);

        int minCostClimbingStairs4 = minCostClimbingStairs4(cost);
        System.out.println("minCostClimbingStairs4 : "+minCostClimbingStairs4);

    }

    //recursive approach
    public static int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        return recur1(n, cost);
    }
    public static int recur1(int n, int []cost){
        //base case
        if (n==0 || n==1){
            return 0;
        }
        int oneStep = cost[n-1] + recur1(n-1, cost);
        int twoStep = cost[n-2] + recur1(n-2, cost);
        return Math.min(oneStep, twoStep);
    }

    //top down approach
    public static int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int []dp = new int[n+1];
        Arrays.fill(dp, -1);
        return recur2(n, cost, dp);
    }
    public static int recur2(int n, int []cost, int []dp){
        //base case
        if (n==0 || n==1){
            dp[n] = 0;
            return 0;
        }
        if (dp[n] != -1){
            return dp[n];
        }
        int oneStep = cost[n-1] + recur2(n-1, cost, dp);
        int twoStep = cost[n-2] + recur2(n-2, cost, dp);
        dp[n] = Math.min(oneStep, twoStep);
        return dp[n];
    }

    // bottom up approach
    public static int minCostClimbingStairs3(int[] cost) {
        int n = cost.length;
        int []dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;

        for (int state = 2; state <= n; state++) {
            int oneStep = cost[state - 1] + dp[state - 1];
            int twoStep = cost[state - 2] + dp[state - 2];
            dp[state] = Math.min(oneStep, twoStep);
        }
        return dp[n];
    }

    // bottom up approach optimize
    public static int minCostClimbingStairs4(int[] cost) {
        int n = cost.length;
        int prev2 = 0;
        int prev1 = 0;
        int ans = 0;

        for (int state = 2; state <= n; state++) {
            int oneStep = cost[state - 1] + prev1;
            int twoStep = cost[state - 2] + prev2;
            ans = Math.min(oneStep, twoStep);
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }
}
